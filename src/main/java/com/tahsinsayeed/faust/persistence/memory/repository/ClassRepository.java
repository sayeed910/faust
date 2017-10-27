package com.tahsinsayeed.faust.persistence.memory.repository;

import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.interactor.Repository;

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
