package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.dto.BookDto;
import com.tahsinsayeed.faust.business.entity.Book;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.BookDataModel;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by IMON on 9/1/2017.
 */
public class BookRepository implements Repository<BookDto, Book> {

    private Dao<BookDataModel, String> assignmentDao;
     BookRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            assignmentDao = DaoManager.createDao(connectionSource, BookDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

     BookRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Book get(String id) {

        try {
            return assignmentDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Book> getAll() {
        try {
            return assignmentDao.queryForAll();
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
