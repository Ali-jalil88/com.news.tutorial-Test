package com.zyadeh.kamel.dao.impl;

import com.zyadeh.kamel.dao.Dao;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.entities.Tag;
import com.zyadeh.kamel.exceptions.DAOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.zyadeh.kamel.statics.ConstantHolder.*;
@Repository
public class TagDAO extends Dao<Tag> {

    public TagDAO(JdbcTemplate connection) {
        super(connection);
    }

    @Override
    public boolean update(Tag entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(TAG_UPDATE)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getId());
            int i = preparedStatement.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update tags");
        }
        return false;
    }

    @Override
    public int insert(Tag entity) throws DAOException {
        try (PreparedStatement preparedStatement  = connection.prepareStatement(TAG_INSERT)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.executeUpdate();
            return getLastInsertId();
        } catch (SQLException e) {
            throw new DAOException("exception during inserting tags");
        }
    }

    @Override
    public void delete(Tag entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(TAG_DELETE)){
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("exception during deleting tags");
        }
    }

    @Override
    public Tag selectById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(TAG_SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Tag tags = new Tag();
                tags.setId(resultSet.getInt("id"));
                tags.setName(resultSet.getString("name"));
                return tags ;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get tags by id is invalid");
        }
    }

    @Override
    public List<Tag> select() throws DAOException {
        ArrayList<Tag> newsArrayList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(TAG_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Tag tags = new Tag();
                tags.setId(resultSet.getInt("id"));
                tags.setName("name");
                newsArrayList.add(tags);
                System.out.println(tags);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during getting list of tags");
        }
        return newsArrayList;
    }

    @Override
    public Tag selectByLogin(String login, String password) throws DAOException {
        return null;
    }

    @Override
    protected int getLastInsertId() throws DAOException {
        return 0;
    }
}
