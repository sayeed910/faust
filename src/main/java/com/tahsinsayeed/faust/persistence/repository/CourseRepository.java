package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.dto.CourseDto;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.*;
import com.tahsinsayeed.faust.persistence.mapper.*;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IMON on 8/13/2017.
 */
public class CourseRepository implements Repository<CourseDto, Course> {
    private final DataModelToEntityMapper<CourseDataModel, Course> mapper;
    private Dao<CourseDataModel, String> courseDao;
     CourseRepository(DBConnection connection, DataModelToEntityMapper<CourseDataModel, Course> mapper){
         this.mapper = mapper;
         ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            courseDao = DaoManager.createDao(connectionSource, CourseDataModel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     CourseRepository() {
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
            return courseDao.queryForAll().stream()
                    .map(mapper::map).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(CourseDto objectToSave) {
        try {
            courseDao.create(new CourseDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CourseDto objectToUpdate) {
        try {
            courseDao.update(new CourseDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(CourseDto objectToDelete) {
        try {
            courseDao.delete(new CourseDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
