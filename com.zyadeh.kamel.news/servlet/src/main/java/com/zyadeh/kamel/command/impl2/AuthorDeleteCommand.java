package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.AuthorService;

import javax.servlet.http.HttpServletRequest;
import java.util.Scanner;

public class AuthorDeleteCommand implements Command {
    private final AuthorService service = new AuthorService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Author author = service.read(12);
        service.delete(author);
        return null;
    }
}
