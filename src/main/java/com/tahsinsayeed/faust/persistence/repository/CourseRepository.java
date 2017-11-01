package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.CourseDataModel;
import com.tahsinsayeed.faust.persistence.mapper.CourseMapper;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by IMON on 8/13/2017.
 */
public class CourseRepository implements Repository<Course> {

    private Dao<CourseDataModel, String> courseDao;
    private DataModelToEntityMapper<CourseDataModel, Course> mapper;
    CourseRepository(DBConnection connection, DataModelToEntityMapper<CourseDataModel, Course> mapper){
        this.mapper = mapper;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            courseDao = DaoManager.createDao(connectionSource, CourseDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public CourseRepository() {
        this(DBConnection.getInstance(), new CourseMapper());
    }

    @Override
    public Course get(String id) {

        try {
            return mapper.map(courseDao.queryForId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Course> getAll() {
        try {
            return courseDao.queryForAll().stream().map(mapper::map).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Course objectToSave) {
        try {
            courseDao.create(new CourseDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Course objectToUpdate) {
        try {
            courseDao.update(new CourseDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Course objectToDelete) {
        try {
            courseDao.delete(new CourseDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean idExists(String id){
        try {
            return courseDao.idExists(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
