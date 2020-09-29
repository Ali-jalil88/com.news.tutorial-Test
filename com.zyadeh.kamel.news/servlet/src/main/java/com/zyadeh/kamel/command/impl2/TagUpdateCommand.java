package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Tag;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Scanner;
@Component("")
public class TagUpdateCommand implements Command {
    private final TagService service;
@Autowired
    public TagUpdateCommand(TagService service) {
        this.service = service;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Tag tag = service.read(61);
        tag.setName("test");
        service.update(tag);
        return null;
    }
}
