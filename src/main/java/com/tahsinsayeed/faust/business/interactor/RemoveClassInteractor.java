package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Class;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveClassInteractor implements Interactor {
    private final Repository<Class> classRepository;

    public RemoveClassInteractor(Repository<Class> classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public void execute(Request request) {

    }
}
