package com.zyadeh.kamel.dao.impl;

import com.zyadeh.kamel.dao.Dao;
import com.zyadeh.kamel.entities.Author;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.exceptions.DAOException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.zyadeh.kamel.statics.ConstantHolder.*;

public class NewsDAO extends Dao<News> {

    @Override
    public boolean update(News entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(NEWS_UPDATE)){
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getShortText());
            preparedStatement.setString(3, entity.getFullText());
            preparedStatement.setDate(4, Date.valueOf(entity.getPublishedIn()));
            preparedStatement.setDate(5, Date.valueOf(entity.getCreatedIn()));
            preparedStatement.setInt(6, entity.getId());
            int i = preparedStatement.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update news");
        }
        return false;
    }

    @Override
    public int insert(News entity) throws DAOException {
        try (PreparedStatement preparedStatement  = connection.prepareStatement(NEWS_INSERT)){
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getShortText());
            preparedStatement.setString(3, entity.getFullText());
            preparedStatement.setDate(4, Date.valueOf(entity.getPublishedIn()));
            preparedStatement.setDate(5, Date.valueOf(entity.getCreatedIn()));
            preparedStatement.executeUpdate();
            return getLastInsertId();
        } catch (SQLException e) {
            throw new DAOException("exception during inserting news");
        }
    }

    @Override
    public void delete(News entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(NEWS_DELETE)){
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("exception during deleting news");
        }
    }

    @Override
    public News selectById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(NEWS_SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setTitle(resultSet.getString("title"));
                news.setShortText(resultSet.getString("short_text"));
                news.setFullText(resultSet.getString("full_text"));
                news.setPublishedIn(LocalDate.parse(resultSet.getString("published_in")));
                news.setCreatedIn(LocalDate.parse(resultSet.getString("created_in")));
                return news ;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get news by id is invalid");
        }
    }

    @Override
    public List<News> select() throws DAOException {
        ArrayList<News> newsArrayList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(NEWS_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                News news = new News();
                news.setTitle(resultSet.getString("title"));
                news.setShortText(resultSet.getString("short_text"));
                news.setFullText(resultSet.getString("full_text"));
                news.setPublishedIn(LocalDate.parse(resultSet.getString("published_in")));
                news.setCreatedIn(LocalDate.parse(resultSet.getString("created_in")));
                news.setId(resultSet.getInt("id"));
                Author author = new Author();
                author.setId(resultSet.getInt("author_id"));
                news.setAuthor(author);
                newsArrayList.add(news);
                System.out.println(news);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during getting list of news");
        }
        return newsArrayList;
    }

    public List<String> selectImages (int news_id) throws DAOException {
        List<String> urls = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(IMAGE_SELECT)) {
                preparedStatement.setInt(1, news_id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    urls.add(resultSet.getString("url"));
                    System.out.println();
                }
            } catch (SQLException e) {
            throw new DAOException("exception during selecting images");
        }
        return urls;
    }

    @Override
    public News selectByLogin(String login, String password) throws DAOException {
        return null;
    }

    @Override
    protected int getLastInsertId() throws DAOException {
        return 0;
    }
}
