package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.business.entity.Class;

import java.sql.SQLException;
import java.util.*;

import static com.tahsinsayeed.faust.persistence.memory.MemoryDatabase.classes;

/**
 * Created by IMON on 9/1/2017.
 */
public class ClassRepository implements Repository<Class> {


    @Override
    public Class get(String id) {
        return classes.get(id);
    }

    @Override
    public List<Class> getAll() {
        return new ArrayList<>(classes.values());
    }

    @Override
    public void save(Class objectToSave) {
        classes.put(UUID.randomUUID().toString(), objectToSave);
    }

    @Override
    public void update(Class objectToUpdate) {

    }

    @Override
    public void delete(Class objectToDelete) {
    }
}
