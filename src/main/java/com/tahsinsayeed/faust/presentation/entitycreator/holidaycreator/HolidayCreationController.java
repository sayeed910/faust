package com.tahsinsayeed.faust.presentation.entitycreator.holidaycreator;

import com.google.inject.Inject;
import com.jfoenix.controls.*;
import com.tahsinsayeed.faust.business.interactor.Request;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.util.ContentValues;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;

/**
 * Created by Shamim on 10/26/17.
 */
public class HolidayCreationController implements EntityCreationController {
    private final RequestBuilder requestBuilder;
    private InteractorFactory interactorFactory;
    Label error;
    JFXTextField nameInput;
    JFXDatePicker dtHolidayDate;

    @Inject
    public HolidayCreationController(RequestBuilder requestBuilder, InteractorFactory factory){
        this.requestBuilder = requestBuilder;
        this.interactorFactory = factory;
    }

    @Override
    public void add() {
        ContentValues values = getRequestArgs();
        Interactor HolidayCreator = interactorFactory.make(InteractorFactory.InteractorType.ADD_HOLIDAY);
        Request newHolidayRequest = requestBuilder.make(RequestBuilder.RequestType.NEW_HOLIDAY, values);

        HolidayCreator.execute(newHolidayRequest);

    }



    private ContentValues getRequestArgs() {
        String HolidayName = nameInput.getText().trim();
        String dateOfHoliday = dtHolidayDate.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE);


        return new ContentValues(
                "holidayName", HolidayName,
                "dueDate", dateOfHoliday
        );

    }

    @Override
    public void cancel() {

    }
}
