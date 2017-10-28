package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.dto.HolidayDto;
import com.tahsinsayeed.faust.business.entity.Holiday;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.HolidayDataModel;

import java.sql.SQLException;
import java.util.*;


/**
 * Created by IMON on 8/13/2017.
 */
public class HolidayRepository implements Repository<HolidayDto, Holiday> {
    private  Dao<HolidayDataModel, String> holidayDao;
     HolidayRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            holidayDao = DaoManager.createDao(connectionSource, HolidayDataModel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     HolidayRepository() {
        this(DBConnection.getInstance());
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
    public void save(HolidayDto objectToSave) {
        try {
            holidayDao.create(new HolidayDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HolidayDto objectToUpdate) {
        try {
            holidayDao.update(new HolidayDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HolidayDto objectToDelete) {
        try {
            holidayDao.delete(new HolidayDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
