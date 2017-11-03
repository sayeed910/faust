package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Book;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class ChangeBookInteractor implements Interactor {
    private final Repository<Book> bookRepository;

    public ChangeBookInteractor(Repository<Book> bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void execute(Request request) {

    }
}
