package com.tahsinsayeed.studykit.repository;

import java.util.List;

public interface Repository<T> {
     T get(String id);
     List<T> getAll();
     void update(T entityToUpdate);
     void save(T entityToSave);
     void delete(T entitiyToDelete);
}
