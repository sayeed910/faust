package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.business.entity.Event;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


/**
 * Created by IMON on 8/13/2017.
 */
public class EventRepository implements Repository<Event> {
    private Dao<Event, String> eventDao;
    private final DBConnection connection;
    public EventRepository(DBConnection connection){
        this.connection = connection;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            eventDao = DaoManager.createDao(connectionSource, Event.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EventRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Event get(String id) {

        try {
            return eventDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Event> getAll() {
        try {
            return eventDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Event objectToSave) {
        try {
            eventDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Event objectToUpdate) {
        try {
            eventDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Event objectToDelete) {
        try {
            eventDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
