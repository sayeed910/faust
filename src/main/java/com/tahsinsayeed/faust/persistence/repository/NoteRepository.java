package com.tahsinsayeed.faust.persistence.repository;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.support.ConnectionSource;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.interactor.Repository;
import com.tahsinsayeed.faust.persistence.DBConnection;
import com.tahsinsayeed.faust.persistence.datamodel.*;
import com.tahsinsayeed.faust.persistence.mapper.NoteMapper;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sayeed on 11/2/17.
 */
public class NoteRepository<T> implements Repository<Note> {

    private Dao<NoteDataModel, String> noteDao;
    private DataModelToEntityMapper<NoteDataModel, Note> mapper;

    public NoteRepository(DBConnection connection, DataModelToEntityMapper<NoteDataModel, Note> mapper){
        this.mapper = mapper;
        ConnectionSource connectionSource = connection.getConnectionSource();
        try {
            noteDao = DaoManager.createDao(connectionSource, NoteDataModel.class);
        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public NoteRepository() {
        this(DBConnection.getInstance(), new NoteMapper());
    }

    @Override
    public Note get(String id) {

        try {
            return mapper.map(noteDao.queryForId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Note> getAll() {
        try {
            return noteDao.queryForAll().stream().map(mapper::map).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Note objectToSave) {
        try {
            noteDao.create(new NoteDataModel(objectToSave));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Note objectToUpdate) {
        try {
            noteDao.update(new NoteDataModel(objectToUpdate));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Note objectToDelete) {
        try {
            noteDao.delete(new NoteDataModel(objectToDelete));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean idExists(String id) {
        try {
            return noteDao.idExists(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
