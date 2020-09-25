package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Tag;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.TagService;

import javax.servlet.http.HttpServletRequest;
import java.util.Scanner;

public class TagDeleteCommand implements Command {
    private final TagService service = new TagService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Tag tag = service.read(62);
        service.delete(tag);
        return null;
    }
}
