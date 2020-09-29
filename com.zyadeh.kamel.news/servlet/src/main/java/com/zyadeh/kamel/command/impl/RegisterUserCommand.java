package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Role;
import com.zyadeh.kamel.entities.User;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
@Component("")
public class RegisterUserCommand implements Command {
    private UserService userService;
    @Autowired
    public RegisterUserCommand(UserService userService) {
        this.userService = userService;
    }
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/login.jsp",true);
        User u = new User();
        u.setName(req.getParameter("firstName"));
        u.setLastName(req.getParameter("lastName"));
        u.setLogin(req.getParameter("login"));
        u.setPassword(req.getParameter("password"));
        u.setEmail(req.getParameter("email"));
        Role role = new Role();
        role.setRole(req.getParameter("role"));
        u.setRole(role);
        userService.create(u);
        return page;
    }
}
