package com.zyadeh.kamel.service.impl;

import com.zyadeh.kamel.dao.impl.UserDAO;
import com.zyadeh.kamel.entities.Role;
import com.zyadeh.kamel.entities.User;
import com.zyadeh.kamel.exceptions.DAOException;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.CRUDService;
import com.zyadeh.kamel.dao.impl.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends CRUDService<Role> {

    private RoleDAO roleDAO;
@Autowired
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public RoleService() {

    }

    @Override
    public void create(Role entity) throws ServiceException {
        try {
            roleDAO.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant create this role");
        }
    }

    @Override
    public Role read(int id) throws ServiceException {
        try {
            return roleDAO.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read this role");
        }
    }

    @Override
    public void update(Role entity) throws ServiceException {
        try {
            roleDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update this role");
        }
    }

    @Override
    public void delete(Role entity) throws ServiceException {
        try {
            roleDAO.delete(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete this row");
        }
    }
}
