package com.zyadeh.kamel.dao.impl;


import com.zyadeh.kamel.dao.Dao;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.exceptions.DAOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.zyadeh.kamel.statics.ConstantHolder.*;
@Repository
public class AuthorDAO extends Dao<Author> {

    public AuthorDAO(JdbcTemplate connection) {
        super(connection);
    }
    @Override
    public boolean update(Author entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(AUTHORS_UPDATE)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getId());
            int i = preparedStatement.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update author");
        }
        return false;
    }
    @Override
    public int insert(Author entity) throws DAOException {
        try (PreparedStatement preparedStatement  = connection.prepareStatement(AUTHORS_INSERT)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.executeUpdate();
            return getLastInsertId();
        } catch (SQLException e) {
            throw new DAOException("exception during inserting author");
        }
    }

    @Override
    public void delete(Author entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(AUTHORS_DELETE)){
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("exception during deleting author");
        }
    }

    @Override
    public Author selectById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(AUTHORS_SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                author.setLastName(resultSet.getString("last_name"));
                return author;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get author by id is invalid");
        }
    }

    @Override
    public List<Author> select() throws DAOException {
        ArrayList<Author> authors = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(AUTHORS_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                author.setLastName(resultSet.getString("last_name"));
                authors.add(author);
            }
        } catch (SQLException e) {
            throw new DAOException("Exception during getting list of authors");
        }
        return authors;
    }

    @Override
    public Author selectByLogin(String login, String password) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(AUTHORS_LOGIN)){
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                author.setLastName(resultSet.getString("last_name"));
                return author;
            }
        } catch (SQLException e) {
            throw new DAOException("select author by login failed");
        }
        return null;
    }

    @Override
    protected int getLastInsertId() throws DAOException {
        return 0;
    }
}
