package com.tahsinsayeed.studykit.repository;

import com.tahsinsayeed.studykit.database.DBHandler;
import com.tahsinsayeed.studykit.model.Holiday;
import org.sormula.Database;
import org.sormula.SormulaException;
import org.sormula.Table;

import java.util.List;

/**
 * Created by IMON on 8/13/2017.
 */
public class HolidayRepository extends Table<Holiday> implements Repository<Holiday> {
    public HolidayRepository(Database database, Class<Holiday> rowClass) throws SormulaException {
        super(database, rowClass);
    }

    @Override
    public List<Holiday> getAll() {
        try {
            return hibernate.selectAll();
        } catch (SormulaException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Holiday get(String id) {
        return null;
    }

    public void save(){

    }

}
