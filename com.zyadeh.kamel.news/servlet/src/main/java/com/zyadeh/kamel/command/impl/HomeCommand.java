package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements Command {

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        return new Page("/pages/home.jsp",true);
    }
}
