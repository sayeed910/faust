package com.tahsinsayeed.faust.persistence.memory.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.persistence.DBConnection;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by IMON on 9/1/2017.
 */
public class ExamRepository implements Repository<Exam> {

    private Dao<Exam, String> examDao;

    ExamRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            examDao = DaoManager.createDao(connectionSource, Exam.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ExamRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Exam get(String id) {

        try {
            return examDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Exam> getAll() {
        try {
            return examDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Exam objectToSave) {
        try {
            examDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Exam objectToUpdate) {
        try {
            examDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Exam objectToDelete) {
        try {
            examDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
