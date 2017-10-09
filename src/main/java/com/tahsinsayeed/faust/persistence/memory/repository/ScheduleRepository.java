package com.tahsinsayeed.faust.persistence.memory.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Schedule;
import com.tahsinsayeed.faust.persistence.DBConnection;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by IMON on 9/1/2017.
 */
public class ScheduleRepository implements Repository<Schedule> {

    private Dao<Schedule, String> scheduleDao;
     ScheduleRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            scheduleDao = DaoManager.createDao(connectionSource, Schedule.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

     ScheduleRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Schedule get(String id) {

        try {
            return scheduleDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Schedule> getAll() {
        try {
            return scheduleDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Schedule objectToSave) {
        try {
            scheduleDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Schedule objectToUpdate) {
        try {
            scheduleDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Schedule objectToDelete) {
        try {
            scheduleDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
