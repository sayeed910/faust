package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Holiday;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.HolidayDataModel;
import com.tahsinsayeed.faust.persistence.mapper.HolidayMapper;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by IMON on 8/13/2017.
 */
public class HolidayRepository implements Repository<Holiday> {

    private Dao<HolidayDataModel, String> holidayDao;
    private DataModelToEntityMapper<HolidayDataModel, Holiday> mapper;
    HolidayRepository(DBConnection connection, DataModelToEntityMapper<HolidayDataModel, Holiday> mapper){
        this.mapper = mapper;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            holidayDao = DaoManager.createDao(connectionSource, HolidayDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    HolidayRepository() {
        this(DBConnection.getInstance(), new HolidayMapper());
    }


    @Override
    public Holiday get(String id) {

        try {
            return mapper.map(holidayDao.queryForId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Holiday> getAll() {
        try {
            return holidayDao.queryForAll().stream().map(mapper::map).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Holiday objectToSave) {
        try {
            holidayDao.create(new HolidayDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Holiday objectToUpdate) {
        try {
            holidayDao.update(new HolidayDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Holiday objectToDelete) {
        try {
            holidayDao.delete(new HolidayDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean idExists(String id) {
        try {
            return holidayDao.idExists(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
