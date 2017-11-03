package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.business.entity.Note;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

/**
 * Created by IMON on 11/3/2017.
 */
public class RemoveNoteInteractor implements Interactor {
    private final Repository<Note> noteRepository;

    public RemoveNoteInteractor(Repository<Note> noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void execute(Request request) {

    }
}
