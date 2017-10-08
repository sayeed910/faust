package com.tahsinsayeed.studykit.persistence.repository;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.studykit.persistence.DBConnection;
import com.tahsinsayeed.studykit.business.entity.Semester;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


/**
 * Created by IMON on 8/13/2017.
 */
public class SemesterRepository implements Repository<Semester> {
    private Dao<Semester, String> semesterDao;
    private final DBConnection connection;
    public SemesterRepository(DBConnection connection){
        this.connection = connection;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            semesterDao = DaoManager.createDao(connectionSource, Semester.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SemesterRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Semester get(String id) {

        try {
            return semesterDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Semester> getAll() {
        try {
            return semesterDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Semester objectToSave) {
        try {
            semesterDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Semester objectToUpdate) {
        try {
            semesterDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Semester objectToDelete) {
        try {
            semesterDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
