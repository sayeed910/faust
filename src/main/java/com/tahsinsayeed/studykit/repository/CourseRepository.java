package com.tahsinsayeed.studykit.repository;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.studykit.database.DBConnection;
import com.tahsinsayeed.studykit.model.Course;
import com.tahsinsayeed.studykit.model.Course;



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
public class CourseRepository implements Repository<Course> {
    private Dao<Course, String> courseDao;
    private final DBConnection connection;
    public CourseRepository(DBConnection connection){
        this.connection = connection;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            courseDao = DaoManager.createDao(connectionSource, Course.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CourseRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Course get(String id) {

        try {
            return courseDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Course> getAll() {
        try {
            return courseDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Course objectToSave) {
        try {
            courseDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Course objectToUpdate) {
        try {
            courseDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Course objectToDelete) {
        try {
            courseDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
