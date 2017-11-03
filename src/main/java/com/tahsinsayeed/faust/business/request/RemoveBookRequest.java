package com.tahsinsayeed.faust.business.request;

import com.tahsinsayeed.faust.business.interactor.Request;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveBookRequest extends Request{
    public String name;

    public RemoveBookRequest(String name) {
        this.name = name;
    }
}
