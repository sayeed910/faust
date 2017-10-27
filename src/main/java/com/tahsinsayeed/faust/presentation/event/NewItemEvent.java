package com.tahsinsayeed.faust.presentation.event;

/**
 * Created by sayeed on 10/27/17.
 */
public class NewItemEvent extends UserEvent {
    public final String itemName;

    public NewItemEvent(String itemName) {
        this.itemName = itemName;
    }
}
