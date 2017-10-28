package com.tahsinsayeed.faust.business.interactor;

import java.util.List;

public interface Repository<S, T> {
    T get(String id);
    List<T> getAll();
    void save(S objectToSaveDto);
    void update(S objectToUpdateDto);
    void delete(S objectToDeleteDto);


}
