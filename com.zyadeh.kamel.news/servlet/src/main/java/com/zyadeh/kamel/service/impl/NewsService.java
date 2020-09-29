package com.zyadeh.kamel.service.impl;

import com.zyadeh.kamel.dao.impl.AuthorDAO;
import com.zyadeh.kamel.dao.impl.NewsDAO;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.DAOException;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsService extends CRUDService<News> {
private NewsDAO newsDAO;
    @Autowired
    public NewsService(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }
    private AuthorDAO authorDAO;
@Autowired
    public NewsService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }
    @Override
    public void create(News entity) throws ServiceException {
        try {
            Author author = entity.getAuthor();
            authorDAO.selectById(author.getId());
            newsDAO.insert(entity);
        } catch (DAOException e){
            throw new ServiceException("cant create this news");
        }

    }

    @Override
    public News read(int id) throws ServiceException {
        try {
            return newsDAO.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read this news");
        }
    }

    @Override
    public void update(News entity) throws ServiceException {
        try {
            Author author = new Author();
            authorDAO.selectById(author.getId());
            newsDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update this news");
        }
    }

    @Override
    public void delete(News entity) throws ServiceException {
        try {
            newsDAO.delete(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete this news");
        }
    }

    public List<News> readAll() throws ServiceException {
        try {
            List<News> newsList = newsDAO.select();
            for (News news : newsList) {
                Author author = authorDAO.selectById(news.getAuthor().getId());
                news.setAuthor(author);
                List<String> urlList = newsDAO.selectImages(news.getId());
                System.out.println(urlList);
                news.setUrls(urlList);
            }
            return newsList;
        } catch (DAOException e) {
            throw new ServiceException("cant get news from list of news");
        }
    }

}
