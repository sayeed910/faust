package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Book;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.BookDataModel;
import com.tahsinsayeed.faust.persistence.mapper.BookMapper;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IMON on 9/1/2017.
 */
public class BookRepository implements Repository<Book> {

    private Dao<BookDataModel, String> bookDao;
    private DataModelToEntityMapper<BookDataModel, Book> mapper;

    BookRepository(DBConnection connection,DataModelToEntityMapper<BookDataModel, Book> mapper){
        this.mapper = mapper;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            bookDao = DaoManager.createDao(connectionSource, BookDataModel.class);
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
            return mapper.map(bookDao.queryForId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Book> getAll() {
        try {
            return bookDao.queryForAll().stream().map(mapper::map).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Book objectToSave) {
        try {
            bookDao.create(new BookDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book objectToUpdate) {
        try {
            bookDao.update(new BookDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Book objectToDelete) {
        try {
            bookDao.delete(new BookDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
