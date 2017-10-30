package com.tahsinsayeed.faust.persistence;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.tahsinsayeed.faust.persistence.datamodel.*;

import java.sql.SQLException;

public class Database {
    DBConnection connection;

    private Database(DBConnection connection){
        this.connection = connection;
    }


    public static Database getInstance(DBConnection connectionSource){
        return new Database(connectionSource);
    }

    public void create() {
        ConnectionSource connectionSource = connection.getConnectionSource();

        try {
            TableUtils.createTable(connectionSource, AssignmentDataModel.class);
            TableUtils.createTable(connectionSource, ClassDataModel.class);
            TableUtils.createTable(connectionSource, CourseDataModel.class);
            TableUtils.createTable(connectionSource, ExamDataModel.class);
            TableUtils.createTable(connectionSource, HolidayDataModel.class);
            TableUtils.createTable(connectionSource, BookDataModel.class);
            TableUtils.createTable(connectionSource, NoteDataModel.class);
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }

    }



    public void upgrade() throws SQLException {

        dropAllTables();
        create();

    }

    private void dropAllTables() throws SQLException {
        ConnectionSource connectionSource = connection.getConnectionSource();

        TableUtils.dropTable(connectionSource, AssignmentDataModel.class, true);
        TableUtils.dropTable(connectionSource, ClassDataModel.class, true);
        TableUtils.dropTable(connectionSource, CourseDataModel.class, true);
        TableUtils.dropTable(connectionSource, ExamDataModel.class, true);
        TableUtils.dropTable(connectionSource, HolidayDataModel.class, true);

    }




}
