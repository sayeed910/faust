package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.dto.ExamDto;
import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.ExamDataModel;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by IMON on 9/1/2017.
 */
public class ExamRepository implements Repository<ExamDto, Exam> {

    private Dao<ExamDataModel, String> examDao;

    ExamRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            examDao = DaoManager.createDao(connectionSource, ExamDataModel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ExamRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Exam get(String id) {

        try {
            return examDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Exam> getAll() {
        try {
            return examDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(ExamDto objectToSave) {
        try {
            examDao.create(new ExamDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ExamDto objectToUpdate) {
        try {
            examDao.update(new ExamDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ExamDto objectToDelete) {
        try {
            examDao.delete(new ExamDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
