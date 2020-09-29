package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("home_command")
public class HomeCommand implements Command {
    @Autowired
    public HomeCommand() {
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        return new Page("/pages/home.jsp",true);
    }
}
