package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.NewsService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NewsUpdateCommand implements Command {
    private NewsService service;

    public NewsUpdateCommand(NewsService newsService) {
        this.service = newsService;
    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        formatter = formatter.withLocale(Locale.US);
        Page page = new Page("/pages/news.jsp", false);
        News news = new News();
        Author author = new Author();

        news.setTitle(req.getParameter("title"));
        news.setShortText(req.getParameter("short_text"));
        news.setFullText(req.getParameter("full_text"));
        news.setCreatedIn(LocalDate.parse(req.getParameter("created_in"),formatter));
        news.setPublishedIn(LocalDate.parse(req.getParameter("published_in"), formatter));

        news.setId(Integer.parseInt(req.getParameter("id")));

        author.setName(req.getParameter("name"));
        author.setLastName(req.getParameter("lastName"));

        news.setAuthor(author);

        service.update(news);

//        HttpSession session = req.getSession();
//        session.setAttribute("news", news);
        return page;
    }
}
