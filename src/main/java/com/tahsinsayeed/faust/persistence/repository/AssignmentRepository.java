package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.business.entity.Assignment;

import java.sql.SQLException;
import java.util.*;

import static com.tahsinsayeed.faust.persistence.memory.MemoryDatabase.assignments;

/**
 * Created by IMON on 9/1/2017.
 */
public class AssignmentRepository implements Repository<Assignment> {


    @Override
    public Assignment get(String id) {
        return assignments.get(id);
    }

    @Override
    public List<Assignment> getAll() {
        return new ArrayList<>(assignments.values());
    }

    @Override
    public void save(Assignment objectToSave) {
        assignments.put(objectToSave.getId(), objectToSave);
    }

    @Override
    public void update(Assignment objectToUpdate) {
        assignments.put(objectToUpdate.getId(), objectToUpdate);
    }

    @Override
    public void delete(Assignment objectToDelete) {
        assignments.remove(objectToDelete.getId());
    }
}
