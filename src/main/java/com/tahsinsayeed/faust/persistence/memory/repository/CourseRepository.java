package com.tahsinsayeed.faust.persistence.memory.repository;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.business.entity.Course;


import static com.tahsinsayeed.faust.persistence.memory.MemoryDatabase.courses;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.j256.ormlite.dao.Dao;
import com.tahsinsayeed.faust.persistence.memory.MemoryDatabase;

import java.sql.SQLException;
import java.util.*;


/**
 * Created by IMON on 8/13/2017.
 */
public class CourseRepository implements Repository<Course> {

    @Override
    public Course get(String id) {

        return courses.get(id);
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<>(courses.values());
    }

    @Override
    public void save(Course objectToSave) {
       courses.put(objectToSave.getId(), objectToSave);
    }

    @Override
    public void update(Course objectToUpdate) {
       courses.put(objectToUpdate.getId(), objectToUpdate);
    }

    @Override
    public void delete(Course objectToDelete) {
        courses.remove(objectToDelete.getId(), objectToDelete);
    }

}
