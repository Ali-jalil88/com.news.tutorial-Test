package com.zyadeh.kamel.dao.impl;

import com.zyadeh.kamel.dao.Dao;
import com.zyadeh.kamel.entities.Role;
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
public class RoleDAO extends Dao<Role> {

    public RoleDAO(JdbcTemplate connection) {
        super(connection);
    }

    @Override
    public boolean update(Role entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ROLE_UPDATE)){
            preparedStatement.setString(1, entity.getRole());
            preparedStatement.setInt(2, entity.getId());
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return true;
            }
            return false;
            } catch (SQLException e) {
            throw new DAOException("cant update role");
        }
    }

    @Override
    public int insert(Role entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ROLE_INSERT)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getRole());
            preparedStatement.executeUpdate();
            return getLastInsertId();
        } catch (SQLException ex) {
            throw new DAOException("exception during insert role");
        }
    }

    @Override
    public void delete(Role entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ROLE_DELETE)){
            preparedStatement.setInt(1, entity.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Role role = new Role();
                role.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role selectById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ROLE_SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setRole(resultSet.getString("role"));
                return role;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id");
        }
    }

    @Override
    public List<Role> select() throws DAOException {
            ArrayList<Role> roleArrayList = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(ROLE_SELECT)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Role role = new Role();
                    role.setId(resultSet.getInt("id"));
                    role.setRole(resultSet.getString("role"));
                    roleArrayList.add(role);
                }
            } catch (SQLException e) {
                throw new DAOException("cant get roles");
            }
            return roleArrayList;
    }

    @Override
    public Role selectByLogin(String login, String password) throws DAOException {
        return null;
    }

    @Override
    protected int getLastInsertId() throws DAOException {
        return 0;
    }
}
