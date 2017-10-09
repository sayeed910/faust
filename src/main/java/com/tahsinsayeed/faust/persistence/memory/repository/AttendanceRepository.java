package com.tahsinsayeed.faust.persistence.memory.repository;

import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.business.entity.Attendance;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.*;


/**
 * Created by IMON on 8/13/2017.
 */
public class AttendanceRepository implements Repository<Attendance> {

    private Dao<Attendance, String> attendanceDao;
     AttendanceRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            attendanceDao = DaoManager.createDao(connectionSource, Attendance.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

     AttendanceRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Attendance get(String id) {

        try {
            return attendanceDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Attendance> getAll() {
        try {
            return attendanceDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Attendance objectToSave) {
        try {
            attendanceDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Attendance objectToUpdate) {
        try {
            attendanceDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Attendance objectToDelete) {
        try {
            attendanceDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
