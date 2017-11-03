package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.business.request.ChangeClassRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeClassInteractor implements Interactor {
    private final Repository<Class> classRepository;

    public ChangeClassInteractor(Repository<Class> classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public void execute(Request request) {
        ChangeClassRequest classRequest = (ChangeClassRequest) request;

        Class clas = classRepository.get(classRequest.id);

        clas.setDay(classRequest.day);
        clas.setStartTime(classRequest.startTime);
        classRepository.delete(clas);

    }
}
