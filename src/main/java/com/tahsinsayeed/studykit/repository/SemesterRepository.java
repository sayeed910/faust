package com.tahsinsayeed.studykit.repository;

import com.tahsinsayeed.studykit.database.DBHandler;
import com.tahsinsayeed.studykit.model.Semester;

public class SemesterRepository implements Repository<Semester> {
    @Override
    public Semester get(String id) {
        DBHandler.connection();
        connection.executeQuery("");
        Semester sem =new Semester();
        sem.Id = result.getString("id");

    }
}
