package com.tahsinsayeed.faust.persistence.memory.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Event;
import com.tahsinsayeed.faust.persistence.DBConnection;

import java.sql.SQLException;
import java.util.*;


/**
 * Created by IMON on 8/13/2017.
 */
public class EventRepository implements Repository<Event> {
    private Dao<Event, String> eventDao;
     EventRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            eventDao = DaoManager.createDao(connectionSource, Event.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     EventRepository() {
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
