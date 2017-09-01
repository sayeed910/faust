package com.tahsinsayeed.studykit.repository;

import java.util.List;

public interface Repository<T> {
    T get(String id);
    List<T> getAll();
    void save(T objectToSave);
    void update(T objectToUpdate);
    void delete(T objectToDelete);
}
