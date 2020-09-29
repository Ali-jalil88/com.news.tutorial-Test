package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.User;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
@Component("")
public class UserReadCommand implements Command {
    private final UserService service;
@Autowired
    public UserReadCommand(UserService service) {
        this.service = service;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        User user = service.read(2);
        System.out.println(user);
        return null;
    }
}
