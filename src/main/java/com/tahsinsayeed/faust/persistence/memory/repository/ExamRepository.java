package com.tahsinsayeed.faust.persistence.memory.repository;

import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.business.interactor.Repository;

import java.util.*;

import static com.tahsinsayeed.faust.persistence.memory.MemoryDatabase.exams;

/**
 * Created by IMON on 9/1/2017.
 */
public class ExamRepository implements Repository<Exam> {


    @Override
    public Exam get(String id) {

        return exams.get(id);
    }

    @Override
    public List<Exam> getAll() {
        return new ArrayList<>(exams.values());
    }

    @Override
    public void save(Exam objectToSave) {
        exams.put(objectToSave.getExamId(), objectToSave);
    }

    @Override
    public void update(Exam objectToUpdate) {
        exams.put(objectToUpdate.getExamId(), objectToUpdate);
    }

    @Override
    public void delete(Exam objectToDelete) {
        exams.remove(objectToDelete.getExamId());
    }
}
