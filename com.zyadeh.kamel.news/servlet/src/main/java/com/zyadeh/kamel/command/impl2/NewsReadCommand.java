package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.NewsService;
import javax.servlet.http.HttpServletRequest;

public class NewsReadCommand implements Command {
    private final NewsService service = new NewsService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        News news = service.read(21);
        System.out.println(news);
        return null;
    }
}
