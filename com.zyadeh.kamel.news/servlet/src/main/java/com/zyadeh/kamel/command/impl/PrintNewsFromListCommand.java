package com.zyadeh.kamel.command.impl;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Locale;
@Component("news_print_command")
public class PrintNewsFromListCommand implements Command {
    @Autowired
    public PrintNewsFromListCommand(NewsService newsService) {

    }

    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        System.out.println("been called.");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        formatter = formatter.withLocale(Locale.US);
        Page p = new Page("/pages/home.jsp", false);
        Page page = new Page("/pages/news.jsp", true);
        News news = new News();
        Author author = new Author();

        news.setTitle(req.getParameter("title"));
//        System.out.println(req.getParameter("title"));
//        System.out.println(news.getTitle());
        news.setShortText(req.getParameter("shortText"));
        news.setFullText(req.getParameter("fullText"));
        news.setPublishedIn(LocalDate.parse(req.getParameter("publishedIn"), formatter));
        news.setCreatedIn(LocalDate.parse(req.getParameter("createdIn"),formatter));
        news.setId(Integer.parseInt(req.getParameter("id")));
        news.setUrls(Collections.singletonList(req.getParameter("urls")));

        author.setName("name");
        author.setLastName("lastName");
        news.setAuthor(author);
        HttpSession session = req.getSession();
        session.setAttribute("list", news);
        return page;
    }
}
