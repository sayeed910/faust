package com.tahsinsayeed.faust.persistence.memory.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.memory.MemoryDatabase;

import java.sql.SQLException;
import java.util.*;

import static com.tahsinsayeed.faust.persistence.memory.MemoryDatabase.book;

/**
 * Created by IMON on 9/1/2017.
 */
public class BookRepository implements Repository<Book>  {



    @Override
    public Book get(String id) {
        return book.get(id);
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(book.values());
    }

    @Override
    public void save(Book objectToSave) {
       book.put(UUID.randomUUID().toString(), objectToSave);
    }

    @Override
    public void update(Book objectToUpdate) {

    }

    @Override
    public void delete(Book objectToDelete) {

    }
}
