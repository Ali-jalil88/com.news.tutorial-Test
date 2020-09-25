package com.zyadeh.kamel.service.impl;

import com.zyadeh.kamel.dao.impl.TagDAO;
import com.zyadeh.kamel.entities.Tag;
import com.zyadeh.kamel.exceptions.DAOException;
import com.zyadeh.kamel.exceptions.ServiceException;
import com.zyadeh.kamel.service.CRUDService;

public class TagService extends CRUDService<Tag> {

    private TagDAO dao = new TagDAO();

    @Override
    public void create(Tag entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cants insert this tag");
        }
    }

    @Override
    public Tag read(int id) throws ServiceException {
        try {
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read this tag");
        }
    }

    @Override
    public void update(Tag entity) throws ServiceException {
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update this author");
        }
    }

    @Override
    public void delete(Tag entity) throws ServiceException {
          try {
             dao.delete(entity);
           } catch (DAOException e) {
               throw new ServiceException("cant delete this tag");
           }
    }

}
