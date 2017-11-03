package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveHolidayRequest extends Request {
    public String id;

    public RemoveHolidayRequest(String id) {
        this.id = id;
    }
}
