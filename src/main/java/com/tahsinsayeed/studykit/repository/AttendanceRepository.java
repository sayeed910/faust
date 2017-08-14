package com.tahsinsayeed.studykit.repository;

import com.tahsinsayeed.studykit.database.DBHandler;
import com.tahsinsayeed.studykit.model.Attendance;
import org.sormula.Database;
import org.sormula.SormulaException;
import org.sormula.Table;

import java.util.List;

/**
 * Created by IMON on 8/13/2017.
 */
public class AttendanceRepository extends Table<Attendance> implements Repository<Attendance> {
    public AttendanceRepository(Database database, Class<Attendance> rowClass) throws SormulaException {
        super(database, rowClass);
    }

    @Override
    public List<Attendance> getAll() {
        try {
            return hibernate.selectAll();
        } catch (SormulaException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Attendance get(String id) {
        return null;
    }

    public void save(){

    }

}
