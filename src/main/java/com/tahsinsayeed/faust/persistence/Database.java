package com.tahsinsayeed.faust.persistence;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.persistence.datamodel.*;

import java.sql.SQLException;

class Database {
    DBConnection connection;

    private Database(DBConnection connection){
        this.connection = connection;
    }


    public static Database getInstance(DBConnection connectionSource){
        return new Database(connectionSource);
    }

    public void create() throws SQLException {
        ConnectionSource connectionSource = connection.getConnectionSource();

        TableUtils.createTable(connectionSource, AssignmentDataModel.class);
        TableUtils.createTable(connectionSource, ClassDataModel.class);
        TableUtils.createTable(connectionSource, CourseDataModel.class);
        TableUtils.createTable(connectionSource, ExamDataModel.class);
        TableUtils.createTable(connectionSource, HolidayDataModel.class);

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
