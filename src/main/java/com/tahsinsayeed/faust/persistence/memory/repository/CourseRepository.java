package com.tahsinsayeed.faust.persistence.memory.repository;

import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.interactor.Repository;

import java.util.*;

import static com.tahsinsayeed.faust.persistence.memory.MemoryDatabase.courses;


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
