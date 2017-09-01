package com.tahsinsayeed.studykit.repository;

public interface Repository<T> {
    T get(String id);
}
