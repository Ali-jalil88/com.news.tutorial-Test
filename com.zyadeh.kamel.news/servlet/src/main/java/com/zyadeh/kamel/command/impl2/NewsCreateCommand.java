package com.zyadeh.kamel.command.impl2;

import com.zyadeh.kamel.command.Command;
import com.zyadeh.kamel.dev.obj.Page;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.impl.AuthorService;
import com.zyadeh.kamel.service.impl.NewsService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Scanner;

public class NewsCreateCommand implements Command {
    private final NewsService service = new NewsService();
    @Override
    public Page execute(HttpServletRequest req) throws ServiceException {
        News news = new News();
        Author author = new Author();
        news.setTitle("trail");
        news.setShortText("trying the command");
        news.setFullText("trying if the command will work");
        news.setCreatedIn(LocalDate.now());
        news.setPublishedIn(LocalDate.now());
        author.setId(1);
        author.setName("Abby");
        author.setLastName("Martin");
        news.setAuthor(author);
        service.create(news);
        return null;
    }
}
