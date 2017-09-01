package com.tahsinsayeed.studykit.repository;

import com.tahsinsayeed.studykit.model.Course;
import org.sormula.Database;
import org.sormula.SormulaException;
import org.sormula.Table;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.j256.ormlite.dao.Dao;


/**
 * Created by IMON on 8/13/2017.
 */
public class CourseRepository {
    private final static String DATABASE_URL = "jdbc:h2:mem:course";
    private Dao<Course, Integer> courseDao;

}
