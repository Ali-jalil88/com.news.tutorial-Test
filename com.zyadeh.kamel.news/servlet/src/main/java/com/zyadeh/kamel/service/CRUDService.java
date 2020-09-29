package com.zyadeh.kamel.service;

import com.zyadeh.kamel.exceptions.ServiceException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public abstract class CRUDService<T> {

    public abstract void create(T entity) throws ServiceException;

    public abstract T read(int id) throws ServiceException;

    public abstract void update(T entity) throws ServiceException, SQLException;

    public abstract void delete(T entity) throws ServiceException;

    public List<T> readAll() throws ServiceException{
        throw new IllegalStateException();
    }

}
