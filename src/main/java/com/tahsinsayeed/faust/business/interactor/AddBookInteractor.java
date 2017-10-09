package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.persistence.memory.repository.*;

import java.io.File;

public class AddBookInteractor implements Interactor {
    private final String name;
    private String parentCourseId;
    private final String filePath;
    private RepositoryFactory repositoryFactory;
    private DtoBank dtoBank = DtoBank.getInstance();

    public AddBookInteractor(String name, String parentCourseId, String filePath) {
        this.parentCourseId = parentCourseId;
        this.filePath = filePath;
        this.name = name;
        this.repositoryFactory = new RepositoryFactoryImpl();
    }

    @Override
    public void execute() {
        Repository<Book> bookRepository = repositoryFactory.getBookRepository();
        Book book = Book.create(name,parentCourseId, new File(filePath));
        bookRepository.save(book);

        BookDto bookDto = new BookDto(book);
        dtoBank.addBook(bookDto);

    }

}
