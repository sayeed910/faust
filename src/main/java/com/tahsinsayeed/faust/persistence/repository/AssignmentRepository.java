package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.AssignmentDataModel;
import com.tahsinsayeed.faust.persistence.mapper.AssignmentMapper;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;


public class AssignmentRepository implements Repository<Assignment> {

    private Dao<AssignmentDataModel, String> assignmentDao;
    private DataModelToEntityMapper<AssignmentDataModel, Assignment> mapper;

    public AssignmentRepository(DBConnection connection, DataModelToEntityMapper<AssignmentDataModel, Assignment> mapper){
         this.mapper = mapper;
         ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            assignmentDao = DaoManager.createDao(connectionSource, AssignmentDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public AssignmentRepository() {
        this(DBConnection.getInstance(), new AssignmentMapper());
    }


    @Override
    public Assignment get(String id) {

        try {
            return mapper.map(assignmentDao.queryForId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Assignment> getAll() {
        try {
            return assignmentDao.queryForAll().stream().map(mapper::map).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Assignment objectToSave) {
        try {
            assignmentDao.create(new AssignmentDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Assignment objectToUpdate) {
        try {
            assignmentDao.update(new AssignmentDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Assignment objectToDelete) {
        try {
            assignmentDao.delete(new AssignmentDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean idExists(String id) {
        try {
            return assignmentDao.idExists(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
