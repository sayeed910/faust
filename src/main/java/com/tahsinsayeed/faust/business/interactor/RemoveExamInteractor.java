package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Exam;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveExamInteractor implements Interactor {
    private final Repository<Exam> examRepository;

    public RemoveExamInteractor(Repository<Exam> examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public void execute(Request request) {

    }
}
