package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.persistence.DBConnection;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by IMON on 9/1/2017.
 */
public class BookRepository implements Repository<Book>  {

    private Dao<Book, String> assignmentDao;
     BookRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            assignmentDao = DaoManager.createDao(connectionSource, Book.class);
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
    public void save(Book objectToSave) {
        try {
            assignmentDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book objectToUpdate) {
        try {
            assignmentDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Book objectToDelete) {
        try {
            assignmentDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
