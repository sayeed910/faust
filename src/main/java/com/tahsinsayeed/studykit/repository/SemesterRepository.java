package com.tahsinsayeed.studykit.repository;

import com.tahsinsayeed.studykit.database.DBHandler;
import com.tahsinsayeed.studykit.model.Semester;
import org.sormula.Database;
import org.sormula.SormulaException;
import org.sormula.Table;

import java.util.List;

/**
 * Created by IMON on 8/13/2017.
 */
public class SemesterRepository extends Table<Semester> implements Repository<Semester> {
    public SemesterRepository(Database database, Class<Semester> rowClass) throws SormulaException {
        super(database, rowClass);
    }

    @Override
    public List<Semester> getAll() {
        try {
            return hibernate.selectAll();
        } catch (SormulaException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Semester get(String id) {
        return null;
    }

    public void save(){

    }

}
