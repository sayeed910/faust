package com.tahsinsayeed.studykit.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.studykit.database.DBConnection;
import com.tahsinsayeed.studykit.model.Exam;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by IMON on 9/1/2017.
 */
public class ExamRepository implements Repository<Exam>  {

    private Dao<Exam, String> examDao;
    private final DBConnection connection;
    public ExamRepository(DBConnection connection){
        this.connection = connection;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            examDao = DaoManager.createDao(connectionSource, Exam.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
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
