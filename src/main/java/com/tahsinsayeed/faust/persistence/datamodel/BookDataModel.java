package com.tahsinsayeed.faust.persistence.datamodel;

import com.tahsinsayeed.faust.business.dto.BookDto;

public class BookDataModel {
    private String name;
    private String parentCourseId;
    private String filePath;

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
