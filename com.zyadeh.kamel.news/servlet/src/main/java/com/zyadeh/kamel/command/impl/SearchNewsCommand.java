package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class SearchNewsCommand implements Command {

    private final NewsService newsService;

    public SearchNewsCommand(NewsService newsService) {
        this.newsService = newsService;
    }
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        HttpSession session1 = req.getSession();
        List<News> news = newsService.readAll();
        List<News> filtered = new ArrayList<>();
        String keyword = req.getParameter("searching");
        for (News n : news) {
            if (n.getTitle().contains(keyword)) {
                filtered.add(n);
                continue;
            }
            if (n.getShortText().contains(keyword)) {
                filtered.add(n);
                continue;
            }
            if (n.getFullText().contains(keyword)) {
                filtered.add(n);
            }
        }
        filtered.isEmpty();
        if (!filtered.isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("filtered", filtered);
        }
        else {
            session1.removeAttribute("filtered");
        }
        return new Page("/pages/search.jsp", false);
    }
}
