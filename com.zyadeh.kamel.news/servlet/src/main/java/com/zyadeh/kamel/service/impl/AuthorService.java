package com.zyadeh.kamel.service.impl;

import com.zyadeh.kamel.dao.impl.AuthorDAO;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.exceptions.DAOException;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService extends CRUDService<Author> {
    private AuthorDAO dao;

    @Autowired
    public AuthorService(AuthorDAO dao) {
        this.dao = dao;
    }
    @Override
    public void create(Author entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cants insert this author");
        }
    }

    @Override
    public Author read(int id) throws ServiceException {
        try {
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read this author");
        }
    }

    @Override
    public void update(Author entity) throws ServiceException {
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update this author");
        }
    }

    @Override
    public void delete(Author entity) throws ServiceException {
        try {
            dao.delete(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete this author");
        }
    }
}
