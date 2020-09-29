package com.zyadeh.kamel.service.impl;

import com.zyadeh.kamel.dao.Dao;
import com.zyadeh.kamel.dao.impl.RoleDAO;
import com.zyadeh.kamel.dao.impl.UserDAO;
import com.zyadeh.kamel.entities.Role;
import com.zyadeh.kamel.entities.User;
import com.zyadeh.kamel.exceptions.DAOException;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class UserService extends CRUDService<User> {
    private Dao<User> dao;
    private final Dao<Role> roleDao;
@Autowired
    public UserService(Dao<Role> roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public void create(User entity) throws ServiceException {
        try {
            Role role = entity.getRole();
            roleDao.selectById(role.getId());
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("user can't insert");
        }
    }
    @Override
    public User read(int id) throws ServiceException {
        try {
            User user = dao.selectById(id);
            user.setRole(roleDao.selectById(id));
            return user;
        } catch (DAOException e) {
            throw new ServiceException("user cant be read");
        }
    }
    @Override
    public void update(User entity) throws ServiceException {
        try {
           dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update User");
        }
    }

    @Override
    public void delete(User entity) throws ServiceException {
        try {
            dao.delete(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete this user");
        }
    }

    public User login(User entity) throws ServiceException {
        try {
            System.out.println(entity);
            User user = dao.selectByLogin(entity.getLogin(), entity.getPassword());
            System.out.println(user);
            Role role = roleDao.selectById(user.getId());
            user.setRole(role);
            return user;
        } catch (DAOException e) {
            throw new ServiceException("user can't login");
        }
    }
}
