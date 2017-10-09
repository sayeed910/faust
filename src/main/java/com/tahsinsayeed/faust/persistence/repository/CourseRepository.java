package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.persistence.DBConnection;

import java.sql.SQLException;
import java.util.*;


/**
 * Created by IMON on 8/13/2017.
 */
public class CourseRepository implements Repository<Course> {
    private Dao<Course, String> courseDao;
     CourseRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            courseDao = DaoManager.createDao(connectionSource, Course.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     CourseRepository() {
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
