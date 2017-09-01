package com.tahsinsayeed.studykit.repository;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.studykit.database.DBConnection;
import com.tahsinsayeed.studykit.model.Holiday;
import com.tahsinsayeed.studykit.model.Holiday;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * Created by IMON on 8/13/2017.
 */
public class HolidayRepository implements Repository<Holiday> {
    private  Dao<Holiday, String> holidayDao;
    private final DBConnection connection;
    public HolidayRepository(DBConnection connection){
        this.connection = connection;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            holidayDao = DaoManager.createDao(connectionSource, Holiday.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Holiday get(String id) {

        try {
            return holidayDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Holiday> getAll() {
        try {
            return holidayDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Holiday objectToSave) {
        try {
            holidayDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Holiday objectToUpdate) {
        try {
            holidayDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Holiday objectToDelete) {
        try {
            holidayDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
