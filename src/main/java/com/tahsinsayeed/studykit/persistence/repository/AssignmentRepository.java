package com.tahsinsayeed.studykit.persistence.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.studykit.persistence.DBConnection;
import com.tahsinsayeed.studykit.business.entity.Assignment;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by IMON on 9/1/2017.
 */
public class AssignmentRepository implements Repository<Assignment>  {

    private Dao<Assignment, String> assignmentDao;
    private final DBConnection connection;
    public AssignmentRepository(DBConnection connection){
        this.connection = connection;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            assignmentDao = DaoManager.createDao(connectionSource, Assignment.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public AssignmentRepository() {
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
    public void save(Assignment objectToSave) {
        try {
            assignmentDao.create(objectToSave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Assignment objectToUpdate) {
        try {
            assignmentDao.update(objectToUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Assignment objectToDelete) {
        try {
            assignmentDao.delete(objectToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
