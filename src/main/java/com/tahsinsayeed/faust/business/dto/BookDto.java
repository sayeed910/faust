package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Book;

public class BookDto {
    private String name;
    private String parentCourseId;
    private String filePath;

    public BookDto() {
    }

    public BookDto(Book book){
        this.name = book.getName();
        this.parentCourseId = book.getParentCourseId();
        this.filePath = book.getFile().getAbsolutePath();
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
