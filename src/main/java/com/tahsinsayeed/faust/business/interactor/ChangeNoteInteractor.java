package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.NoteDto;
import com.tahsinsayeed.faust.business.entity.Note;
import com.tahsinsayeed.faust.business.request.ChangeNoteRequest;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

import java.io.*;

/**
 * Created by sayeed on 11/3/17.
 */
public class ChangeNoteInteractor implements Interactor {

    private final Repository<Note> noteRepository;


    @Inject
    public ChangeNoteInteractor(Repository<Note> noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void execute(Request request) {
        ChangeNoteRequest noteRequest = (ChangeNoteRequest) request;



        Note note = noteRepository.get(noteRequest.id);
        note.setTitle(noteRequest.title);
        File noteFile = note.getFile();
        writeContent(noteFile, noteRequest.content);
        noteRepository.update(note);

        NoteDto noteDto = NoteDto.from(note);
        ViewModelStorage.getInstance().update(noteDto);

    }

    private void writeContent(File noteFile, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(noteFile));
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
