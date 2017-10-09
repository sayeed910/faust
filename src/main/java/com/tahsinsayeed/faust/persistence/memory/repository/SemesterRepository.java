package com.tahsinsayeed.faust.persistence.memory.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Semester;
import com.tahsinsayeed.faust.persistence.DBConnection;

import java.sql.SQLException;
import java.util.*;


/**
 * Created by IMON on 8/13/2017.
 */
public class SemesterRepository implements Repository<Semester> {
    private Dao<Semester, String> semesterDao;

    SemesterRepository(DBConnection connection) {
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            semesterDao = DaoManager.createDao(connectionSource, Semester.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    SemesterRepository() {
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
