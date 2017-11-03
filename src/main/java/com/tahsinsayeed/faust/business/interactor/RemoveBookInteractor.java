package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Book;
import com.tahsinsayeed.faust.business.entity.Book;
import com.tahsinsayeed.faust.business.request.RemoveBookRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveBookInteractor implements Interactor {
    private final Repository<Book> bookRepository;

    public RemoveBookInteractor(Repository<Book> bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void execute(Request request) {
        RemoveBookRequest bookRequest = (RemoveBookRequest) request;

        Book book = bookRepository.get(bookRequest.name);
        bookRepository.delete(book);

    }
}