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
import javax.servlet.http.HttpSession;
@Component("")
public class UserUpdateCommand implements Command
{
    private UserService service;
@Autowired
    public UserUpdateCommand(UserService service) {
        this.service = service;
    }
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/pages/create.jsp", true);
        User user = new User();
        Role role = new Role();
        HttpSession session = req.getSession();
        User user1 = (User) session.getAttribute("user");
        System.out.println("test-user1id => "+user1.getId());
        user.setId(user1.getId());
        user.setName(req.getParameter("first_name"));
        user.setLastName(req.getParameter("last_name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setLogin(req.getParameter("login"));

        role.setRole(req.getParameter("role"));
        user.setRole(role);


        service.update(user);
        return page;
    }
}
