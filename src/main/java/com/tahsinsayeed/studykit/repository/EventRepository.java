package com.tahsinsayeed.studykit.repository;

import com.tahsinsayeed.studykit.database.DBHandler;
import com.tahsinsayeed.studykit.model.Event;
import org.sormula.Database;
import org.sormula.SormulaException;
import org.sormula.Table;

import java.util.List;

/**
 * Created by IMON on 8/13/2017.
 */
public class EventRepository extends Table<Event> implements Repository<Event> {
    public EventRepository(Database database, Class<Event> rowClass) throws SormulaException {
        super(database, rowClass);
    }

    @Override
    public List<Event> getAll() {
        try {
            return hibernate.selectAll();
        } catch (SormulaException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Event get(String id) {
        return null;
    }

    public void save(){

    }

}
