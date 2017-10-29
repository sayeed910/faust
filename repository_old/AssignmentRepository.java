package com.tahsinsayeed.faust.persistence.repository_old;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.dto.AssignmentDto;
import com.tahsinsayeed.faust.business.entity.Assignment;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.AssignmentDataModel;
import com.tahsinsayeed.faust.persistence.mapper.*;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IMON on 9/1/2017.
 */
public class AssignmentRepository implements Repository<AssignmentDto, Assignment> {

    private Dao<AssignmentDataModel, String> assignmentDao;
    private DataModelToEntityMapper<AssignmentDataModel, Assignment> mapper;

     AssignmentRepository(DBConnection connection, DataModelToEntityMapper<AssignmentDataModel, Assignment> mapper){
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            assignmentDao = DaoManager.createDao(connectionSource, AssignmentDataModel.class);
            this.mapper = mapper;
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

     AssignmentRepository() {
        this(DBConnection.getInstance(), new AssignmentMapper() );
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
            return assignmentDao.queryForAll().stream()
                    .map(assignmentDataModel -> mapper.map(assignmentDataModel)).collect(Collectors.toList());
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
