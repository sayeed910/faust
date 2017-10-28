package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.request.NewBookRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

import java.io.File;

public class AddBookInteractor implements Interactor {

    private final Repository<Book> bookRepository;
    private final Repository<Course> courseRepository;

    public AddBookInteractor(Repository<Book> bookRepository, Repository<Course> courseRepository) {

        this.bookRepository = bookRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(Request request) {
        NewBookRequest bookRequest = (NewBookRequest) request;

        Book book = Book.create(bookRequest.name, bookRequest.parentCourseId,new File(bookRequest.filePath));
        bookRepository.save(book);

        BookDto bookDto = BookDto.from(book);
        DtoBank.getInstance().addBook(bookDto);

    }

}
