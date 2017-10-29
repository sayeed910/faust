package com.tahsinsayeed.faust.persistence.repository;

/**
 * Created by sayeed on 10/28/17.
 */
public interface DataModelToEntityMapper <S,T> {
    T map(S dataModel);
}
