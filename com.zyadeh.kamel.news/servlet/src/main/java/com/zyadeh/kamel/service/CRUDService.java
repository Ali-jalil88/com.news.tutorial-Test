package com.zyadeh.kamel.service;

import com.zyadeh.kamel.exceptions.ServiceException;

import java.sql.SQLException;
import java.util.List;

public abstract class CRUDService<T> {

    public abstract void create(T entity) throws ServiceException;

    public abstract T read(int id) throws ServiceException;

    public abstract void update(T entity) throws ServiceException, SQLException;

    public abstract void delete(T entity) throws ServiceException;

    public List<T> readAll() throws ServiceException{
        throw new IllegalStateException();
    }

}
