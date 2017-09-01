package com.tahsinsayeed.studykit.repository;

import com.tahsinsayeed.studykit.model.Attendance;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;




/**
 * Created by IMON on 8/13/2017.
 */
public class AttendanceRepository {
    private final static String DATABASE_URL = "jdbc:h2:mem:attendance";
    private Dao<Attendance, Integer> attendanceDao;

    public static void main(String[] args) throws Exception {
        // turn our static method into an instance of Main
        new AttendanceRepository().doMain(args);
    }

    private void doMain(String[] args) throws Exception {
        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
            // setup our database and DAOs
            setupDatabase(connectionSource);
            // read and write some data
            readWriteData();
            // do a bunch of bulk operations
            readWriteBunch();
            // show how to use the SelectArg object
            useSelectArgFeature();
            // show how to use the SelectArg object
            useTransactions(connectionSource);
            System.out.println("\n\nIt seems to have worked\n\n");
        } finally {
            // destroy the data source which should close underlying connections
            if (connectionSource != null) {
                connectionSource.close();
            }
        }
    }

    /**
     * Setup our database and DAOs
     */
    private void setupDatabase(ConnectionSource connectionSource) throws Exception {

        attendanceDao = DaoManager.createDao(connectionSource, Attendance.class);

        // if you need to create the table
        TableUtils.createTable(connectionSource, Attendance.class);
    }

    /**
     * Read and write some example data.
     */
    private void readWriteData() throws Exception {

    }

    /**
     * Example of reading and writing a large(r) number of objects.
     */
    private void readWriteBunch() throws Exception {


    }

    /**
     * Example of created a query with a ? argument using the {@link SelectArg} object. You then can set the value of
     * this object at a later time.
     */
    private void useSelectArgFeature() throws Exception {


    }

    /**
     * Example of created a query with a ? argument using the {@link SelectArg} object. You then can set the value of
     * this object at a later time.
     */
    private void useTransactions(ConnectionSource connectionSource) throws Exception {

    }




}
