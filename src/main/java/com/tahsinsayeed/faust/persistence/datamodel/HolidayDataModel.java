package com.tahsinsayeed.faust.persistence.datamodel;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tahsinsayeed.faust.business.dto.HolidayDto;

import java.time.format.DateTimeFormatter;

/**
 * Created by sayeed on 10/25/17.
 */

@DatabaseTable(tableName = "HolidayDataModel")
public class HolidayDataModel {

    @DatabaseField
    private String name;

    @DatabaseField
    private String date;

    @DatabaseField(id = true)
    private String id;

    public HolidayDataModel(){

    }

    public HolidayDataModel(HolidayDto holiday){
        this.name = holiday.name;
        this.date = holiday.date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.id = holiday.id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
