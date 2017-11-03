package com.tahsinsayeed.faust.presentation.event;

import com.tahsinsayeed.faust.presentation.model.NoteViewModel;

/**
 * Created by IMON on 11/3/2017.
 */
public class NoteItemSelected {
    public final NoteViewModel noteViewModel;

    public NoteItemSelected(NoteViewModel noteViewModel) {
        this.noteViewModel = noteViewModel;
    }
}
