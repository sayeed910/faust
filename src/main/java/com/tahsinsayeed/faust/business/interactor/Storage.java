package com.tahsinsayeed.faust.business.interactor;

/**
 * Created by sayeed on 11/3/17.
 */
public interface Storage<T> {
    void add(T objectDto);
    void remove(T objectDto);
    void update(T objectDto);
}
