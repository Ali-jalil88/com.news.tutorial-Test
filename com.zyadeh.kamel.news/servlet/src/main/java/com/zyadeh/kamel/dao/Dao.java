package com.zyadeh.kamel.dao;

import com.zyadeh.kamel.dao.connection.ConnectionBuilder;
import com.zyadeh.kamel.exceptions.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao<T> {

    protected Connection connection = ConnectionBuilder.getConnection();

    public abstract boolean update(T entity) throws DAOException;

    public abstract int insert(T entity) throws DAOException;

    public abstract void delete(T entity) throws DAOException;

    public abstract T selectById(int id) throws DAOException;

    public abstract List<T> select() throws DAOException;

    public abstract T selectByLogin(String login, String password) throws DAOException;

    protected abstract int getLastInsertId() throws DAOException;

}


