package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.dto.ClassDto;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.ClassDataModel;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by IMON on 9/1/2017.
 */
public class ClassRepository implements Repository<ClassDto, Class> {

    private Dao<ClassDataModel, String> classDao;

    ClassRepository(DBConnection connection) {
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            classDao = DaoManager.createDao(connectionSource, ClassDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    ClassRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Class get(String id) {

        try {
            return classDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Class> getAll() {
        try {
            return classDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(ClassDto objectToSave) {
        try {
            classDao.create(new ClassDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ClassDto objectToUpdate) {
        try {
            classDao.update(new ClassDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ClassDto objectToDelete) {
        try {
            classDao.delete(new ClassDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
