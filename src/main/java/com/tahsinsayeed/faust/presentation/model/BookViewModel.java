        package com.tahsinsayeed.faust.presentation.model;

import com.tahsinsayeed.faust.business.dto.AssignmentDto;
import com.tahsinsayeed.faust.business.dto.BookDto;
import com.tahsinsayeed.faust.business.entity.Book;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

        public class BookViewModel {
    private StringProperty name;
    private StringProperty  parentCourseId;
    private StringProperty  filePath;

    public BookViewModel() {
    }

    public BookViewModel(BookDto book){
        this.name = new SimpleStringProperty(book.name);
        this.parentCourseId = new SimpleStringProperty(book.parentCourseId);
        this.filePath = new SimpleStringProperty(book.filePath);
    }

    public StringProperty  getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty  getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(String  parentCourseId) {
        this.parentCourseId.set(parentCourseId);
    }

    public StringProperty  getFilePath() {
        return filePath;
    }

    public void setFilePath(String  filePath) {
        this.filePath.set(filePath);
    }
}
