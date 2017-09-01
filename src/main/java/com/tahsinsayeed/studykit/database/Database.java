package com.tahsinsayeed.studykit.database;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.tahsinsayeed.studykit.model.*;
import com.tahsinsayeed.studykit.model.Class;

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

        TableUtils.createTable(connectionSource, Attendance.class);
        TableUtils.createTable(connectionSource, Assignment.class);
        TableUtils.createTable(connectionSource, Class.class);
        TableUtils.createTable(connectionSource, Course.class);
        TableUtils.createTable(connectionSource, Event.class);
        TableUtils.createTable(connectionSource, Exam.class);
        TableUtils.createTable(connectionSource, Holiday.class);
        TableUtils.createTable(connectionSource, Schedule.class);
        TableUtils.createTable(connectionSource, Semester.class);

    }



    public void upgrade() throws SQLException {

        dropAllTables();
        create();

    }

    private void dropAllTables() throws SQLException {
        ConnectionSource connectionSource = connection.getConnectionSource();

        TableUtils.dropTable(connectionSource, Assignment.class, true);
        TableUtils.dropTable(connectionSource, Attendance.class, true);
        TableUtils.dropTable(connectionSource, Class.class, true);
        TableUtils.dropTable(connectionSource, Course.class, true);
        TableUtils.dropTable(connectionSource, Event.class, true);
        TableUtils.dropTable(connectionSource, Exam.class, true);
        TableUtils.dropTable(connectionSource, Holiday.class, true);
        TableUtils.dropTable(connectionSource, Schedule.class, true);
        TableUtils.dropTable(connectionSource, Semester.class, true);


    }




}
