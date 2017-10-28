package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.dto.BookDto;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.*;
import com.tahsinsayeed.faust.persistence.mapper.*;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IMON on 9/1/2017.
 */
public class BookRepository implements Repository<BookDto, Book> {

    private Dao<BookDataModel, String> assignmentDao;
    private DataModelToEntityMapper<BookDataModel, Book> mapper;
     BookRepository(DBConnection connection, DataModelToEntityMapper<BookDataModel, Book> mapper ){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            assignmentDao = DaoManager.createDao(connectionSource, BookDataModel.class);
            this.mapper = mapper;
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

     BookRepository() {
        this(DBConnection.getInstance(), new BookMapper());
    }


    @Override
    public Book get(String id) {

        try {
            return mapper.map(assignmentDao.queryForId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Book> getAll() {
        try {
            return assignmentDao.queryForAll().stream()
                    .map(bookDataModel -> mapper.map(bookDataModel)).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(BookDto objectToSave) {
        try {
            assignmentDao.create(new BookDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(BookDto objectToUpdate) {
        try {
            assignmentDao.update(new BookDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(BookDto objectToDelete) {
        try {
            assignmentDao.delete(new BookDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
