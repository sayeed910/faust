package com.tahsinsayeed.faust.business.interactor;

import java.util.List;

public interface Repository<T> {
    T get(String id);
    List<T> getAll();
    void save(T objectToSaveDto);
    void update(T objectToUpdateDto);
    void delete(T objectToDeleteDto);

    boolean idExists(String id);
}
