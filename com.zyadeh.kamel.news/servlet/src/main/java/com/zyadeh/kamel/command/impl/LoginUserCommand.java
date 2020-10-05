package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.User;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Component("command_login")
public class LoginUserCommand implements Command {
    private UserService userService;
    @Autowired
    public LoginUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/",true);
        User user = new User();
        user.setLogin(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        User u = userService.login(user);
        System.out.println(u);
        if (u != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",u);
            page.setUrl("/home");
            page.setUrl("/users?command=command_fetch");
            return page;
        }

        return page;
    }
}
