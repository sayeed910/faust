package com.tahsinsayeed.studykit.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.studykit.database.DBConnection;
import com.tahsinsayeed.studykit.model.Class;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by IMON on 9/1/2017.
 */
public class ClassRepository implements Repository<Class>  {

    private Dao<Class, String> classDao;
    private final DBConnection connection;
    public ClassRepository(DBConnection connection){
        this.connection = connection;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            classDao = DaoManager.createDao(connectionSource, Class.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
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
    public void save(Class objectToSave) {
        try {
            classDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Class objectToUpdate) {
        try {
            classDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Class objectToDelete) {
        try {
            classDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
