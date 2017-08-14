package com.tahsinsayeed.studykit.repository;

import com.tahsinsayeed.studykit.database.DBHandler;
import com.tahsinsayeed.studykit.model.Course;
import org.sormula.Database;
import org.sormula.SormulaException;
import org.sormula.Table;

import java.util.List;

/**
 * Created by IMON on 8/13/2017.
 */
public class CourseRepository extends Table<Course> implements Repository<Course> {
    public CourseRepository(Database database, Class<Course> rowClass) throws SormulaException {
        super(database, rowClass);
    }

    @Override
    public List<Course> getAll() {
        try {
            return hibernate.selectAll();
        } catch (SormulaException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Course get(String id) {
        return null;
    }

    public void save(){

    }

}
