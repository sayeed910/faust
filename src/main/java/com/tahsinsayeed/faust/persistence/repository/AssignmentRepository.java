package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.dto.AssignmentDto;
import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.AssignmentDataModel;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by IMON on 9/1/2017.
 */
public class AssignmentRepository implements Repository<AssignmentDto, Assignment> {

    private Dao<AssignmentDataModel, String> assignmentDao;
     AssignmentRepository(DBConnection connection){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            assignmentDao = DaoManager.createDao(connectionSource, AssignmentDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

     AssignmentRepository() {
        this(DBConnection.getInstance());
    }


    @Override
    public Assignment get(String id) {

        try {
            return assignmentDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Assignment> getAll() {
        try {
            return assignmentDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(AssignmentDto objectToSave) {
        try {
            assignmentDao.create(new AssignmentDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(AssignmentDto objectToUpdate) {
        try {
            assignmentDao.update(new AssignmentDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(AssignmentDto objectToDelete) {
        try {
            assignmentDao.delete(new AssignmentDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
