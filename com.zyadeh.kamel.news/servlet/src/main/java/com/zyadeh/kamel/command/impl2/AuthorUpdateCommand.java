package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Scanner;
@Component("")
public class AuthorUpdateCommand implements Command {
    private final AuthorService service;
@Autowired
    public AuthorUpdateCommand(AuthorService service) {
        this.service = service;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Author author = service.read(11);
        author.setName("me");
        author.setLastName("myself and I");
        service.update(author);
        return null;
    }
}
