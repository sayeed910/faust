package com.tahsinsayeed.faust.config;

import com.google.inject.*;
import com.tahsinsayeed.faust.presentation.entitycreator.holidaycreator.*;

/**
 * Created by sayeed on 10/31/17.
 */
public class HolidayCreationViewProvider implements Provider<HolidayCreator> {

    @Inject
    HolidayCreationController controller;

    @Override
    public HolidayCreator get() {
        return new HolidayCreator(controller);
    }
}
