package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.ClassDataModel;
import com.tahsinsayeed.faust.persistence.mapper.ClassMapper;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IMON on 9/1/2017.
 */
public class ClassRepository implements Repository<Class> {

    private Dao<ClassDataModel, String> classDao;
    private DataModelToEntityMapper<ClassDataModel, Class> mapper;
    ClassRepository(DBConnection connection, DataModelToEntityMapper<ClassDataModel, Class> mapper){
        this.mapper = mapper;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            classDao = DaoManager.createDao(connectionSource, ClassDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    ClassRepository() {
        this(DBConnection.getInstance(), new ClassMapper());
    }


    @Override
    public Class get(String id) {

        try {
            return mapper.map(classDao.queryForId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Class> getAll() {
        try {
            return classDao.queryForAll().stream().map(mapper::map).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Class objectToSave) {
        try {
            classDao.create(new ClassDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Class objectToUpdate) {
        try {
            classDao.update(new ClassDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Class objectToDelete) {
        try {
            classDao.delete(new ClassDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean idExists(String id) {
        try {
            return classDao.idExists(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
