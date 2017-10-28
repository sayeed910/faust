package com.tahsinsayeed.faust.persistence.datamodel;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.tahsinsayeed.faust.business.dto.BookDto;

@DatabaseTable(tableName = "BookDataModel")
public class BookDataModel {

    @DatabaseField(id = true)
    private String name;

    @DatabaseField
    private String parentCourseId;

    @DatabaseField
    private String filePath;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "course_data_model_id")
    private CourseDataModel courseDataModel;

    public BookDataModel() {
    }

    public BookDataModel(BookDto book){

        this.name = book.name;
        this.parentCourseId = book.parentCourseId;
        this.filePath = book.filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String parentCourseId) {
        this.parentCourseId = parentCourseId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
