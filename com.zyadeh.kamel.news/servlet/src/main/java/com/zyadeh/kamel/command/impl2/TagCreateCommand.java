package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Tag;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.TagService;

import javax.servlet.http.HttpServletRequest;

public class TagCreateCommand implements Command {
    private final TagService service = new TagService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Tag tag = new Tag();
        tag.setName("trail");
        service.create(tag);
        return null;
    }
}
