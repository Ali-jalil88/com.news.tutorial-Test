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
import java.util.ArrayList;
import java.util.List;
@Component("selected_news")
public class SelectedNewsCommand implements Command {
    @Autowired
    public SelectedNewsCommand() {
    }
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        Page page = new Page("/", true);
        HttpSession session = req.getSession();
        int i = Integer.parseInt(req.getParameter("index"));
        List<News> newsList = (List<News>) session.getAttribute("filtered");
        News news = newsList.get(i);
        session.setAttribute("selectedNews",news);
        page.setUrl("/pages/news.jsp");
    return page;

    }
}
