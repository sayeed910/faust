package com.tahsinsayeed.faust.persistence.mapper;

import com.tahsinsayeed.faust.business.entity.Book;
import com.tahsinsayeed.faust.persistence.datamodel.BookDataModel;
import com.tahsinsayeed.faust.persistence.repository.DataModelToEntityMapper;

import java.io.File;

/**
 * Created by sayeed on 10/28/17.
 */
public class BookMapper implements DataModelToEntityMapper<BookDataModel, Book> {
    @Override
    public Book map(BookDataModel dataModel) {
        return Book.create(dataModel.getName(), dataModel.getParentCourseId(), new File(dataModel.getFilePath()));
    }
}
