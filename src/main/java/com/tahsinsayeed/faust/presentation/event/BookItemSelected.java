package com.tahsinsayeed.faust.presentation.event;

import com.tahsinsayeed.faust.presentation.model.BookViewModel;

/**
 * Created by IMON on 11/3/2017.
 */
public class BookItemSelected {
    public final BookViewModel bookViewModel;

    public BookItemSelected(BookViewModel bookViewModel) {
        this.bookViewModel = bookViewModel;
    }
}
