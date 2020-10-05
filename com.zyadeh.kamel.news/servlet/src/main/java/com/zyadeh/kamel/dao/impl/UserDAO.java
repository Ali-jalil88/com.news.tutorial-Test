package com.zyadeh.kamel.dao.impl;


import com.zyadeh.kamel.dao.Dao;
import com.zyadeh.kamel.entities.News;
import com.zyadeh.kamel.entities.Role;
import com.zyadeh.kamel.entities.User;
import com.zyadeh.kamel.exceptions.DAOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.zyadeh.kamel.statics.ConstantHolder.*;
@Repository
public class UserDAO extends Dao<User> {


    public UserDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }
    @Override
    public boolean update(User entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_UPDATE)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setInt(6, entity.getId());

            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            throw new DAOException("exception during update user");
        }
        return false;
    }

    @Override
    public int insert(User entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_INSERT)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.executeUpdate();
            return getLastInsertId();
        } catch (SQLException ex) {
            throw new DAOException("exception during insert user");
        }
    }

    @Override
    public void delete(User entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_DELETE)){
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("cant delete user");
        }
    }

    @Override
    public User selectById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_SELECT_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = getUser(resultSet);
            System.out.println(user);
            if (user != null) return user;
            return null;
        } catch (SQLException e) {
            throw new DAOException("no user with this id exists");
        }
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            return user;
        }
        return null;
    }

    @Override
    public List<User> select() throws DAOException {
        ArrayList<User> userArrayList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                userArrayList.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException("cant get users");
        }
        return userArrayList;
    }

    @Override
    public User selectByLogin(String login, String password) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(USER_LOGIN)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = getUser(resultSet);
            if (user != null) return user;
            return null;
        } catch (SQLException exception) {
            throw new DAOException("no such user with this email and login exists");
        }
    }

    @Override
    protected int getLastInsertId() throws DAOException {
        try (Statement statement = connection.createStatement()) {
            String query = String.format(LAST_INSERT, "users");
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getInt("currval");
            }
            throw new DAOException("no Id has ben founded");
        } catch (SQLException e) {
            throw new DAOException("no Id has ben founded");
        }
    }

}
