package com.tahsinsayeed.faust.presentation.event;

import com.google.common.eventbus.EventBus;

/**
 * Created by sayeed on 11/3/17.
 */
public class Bus {
    private static EventBus bus = new EventBus();

    public static EventBus get(){
        return bus;
    }
}
