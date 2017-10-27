package com.tahsinsayeed.faust.persistence;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.entity.Class;

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

        TableUtils.createTable(connectionSource, Assignment.class);
        TableUtils.createTable(connectionSource, Class.class);
        TableUtils.createTable(connectionSource, Course.class);
        TableUtils.createTable(connectionSource, Exam.class);
        TableUtils.createTable(connectionSource, Holiday.class);
        TableUtils.createTable(connectionSource, Schedule.class);

    }



    public void upgrade() throws SQLException {

        dropAllTables();
        create();

    }

    private void dropAllTables() throws SQLException {
        ConnectionSource connectionSource = connection.getConnectionSource();

        TableUtils.dropTable(connectionSource, Assignment.class, true);
        TableUtils.dropTable(connectionSource, Class.class, true);
        TableUtils.dropTable(connectionSource, Course.class, true);
        TableUtils.dropTable(connectionSource, Exam.class, true);
        TableUtils.dropTable(connectionSource, Holiday.class, true);
        TableUtils.dropTable(connectionSource, Schedule.class, true);


    }




}
