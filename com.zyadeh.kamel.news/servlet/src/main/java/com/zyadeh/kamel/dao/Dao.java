package com.zyadeh.kamel.dao;

import com.zyadeh.kamel.dao.connection.ConnectionBuilder;
import com.zyadeh.kamel.exceptions.DAOException;
import org.postgresql.jdbc4.Jdbc4Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Repository
public abstract class Dao<T> {
    protected JdbcTemplate
@Autowired
    public Dao(JdbcTemplate connection) {
        this.connection = JdbcTemplate.getconnection();
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    protected Connection connection = new JdbcTemplate();

    public abstract boolean update(T entity) throws DAOException;

    public abstract int insert(T entity) throws DAOException;

    public abstract void delete(T entity) throws DAOException;

    public abstract T selectById(int id) throws DAOException;

    public abstract List<T> select() throws DAOException;

    public abstract T selectByLogin(String login, String password) throws DAOException;

    protected abstract int getLastInsertId() throws DAOException;

}


