package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.ExamDataModel;
import com.tahsinsayeed.faust.persistence.mapper.ExamMapper;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IMON on 9/1/2017.
 */
public class ExamRepository implements Repository<Exam> {

    private Dao<ExamDataModel, String> examDao;
    private DataModelToEntityMapper<ExamDataModel, Exam> mapper;
    ExamRepository(DBConnection connection, DataModelToEntityMapper<ExamDataModel, Exam> mapper){
        this.mapper = mapper;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            examDao = DaoManager.createDao(connectionSource, ExamDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    ExamRepository() {
        this(DBConnection.getInstance(), new ExamMapper());
    }


    @Override
    public Exam get(String id) {

        try {
            return mapper.map(examDao.queryForId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Exam> getAll() {
        try {
            return examDao.queryForAll().stream().map(mapper::map).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Exam objectToSave) {
        try {
            examDao.create(new ExamDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Exam objectToUpdate) {
        try {
            examDao.update(new ExamDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Exam objectToDelete) {
        try {
            examDao.delete(new ExamDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
