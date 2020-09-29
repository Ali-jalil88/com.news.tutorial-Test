package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Component("")
public class FetchNewsCommand implements Command {
    private NewsService newsService;
@Autowired
    public FetchNewsCommand(NewsService newsService) {
        this.newsService = newsService;
    }
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        System.out.println("command fetch has called");
        Page page = new Page("/pages/home.jsp", true);
        List<News> news = newsService.readAll();
        if (news != null) {
            HttpSession session = req.getSession();
            session.setAttribute("news", news);
        }
        return page;
    }
}
