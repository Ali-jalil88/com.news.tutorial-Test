package com.zyadeh.kamel.command;

import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;


public interface Command {

    Page execute(HttpServletRequest req) throws ServiceException;


}
