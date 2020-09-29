package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Scanner;
@Component("")
public class NewsDeleteCommand implements Command {
    private final NewsService service ;
@Autowired
    public NewsDeleteCommand(NewsService service) {
        this.service = service;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        News news = service.read(22);
        service.delete(news);
        return null;
    }
}
