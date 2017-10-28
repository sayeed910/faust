package com.tahsinsayeed.faust.business.dto;

import com.tahsinsayeed.faust.business.entity.Book;

public class BookDto {
    public final String name;
    public final String parentCourseId;
    public final String filePath;



    private BookDto(Book book){
        this.name = book.getName();
        this.parentCourseId = book.getParentCourseId();
        this.filePath = book.getFile().getAbsolutePath();
    }

    public static BookDto from(Book book) {
        return new BookDto(book);
    }
}
