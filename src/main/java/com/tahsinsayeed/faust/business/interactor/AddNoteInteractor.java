package com.tahsinsayeed.faust.business.interactor;

import com.google.inject.Inject;
import com.tahsinsayeed.faust.business.dto.*;
import com.tahsinsayeed.faust.business.entity.*;
import com.tahsinsayeed.faust.business.request.*;
import com.tahsinsayeed.faust.config.Config;
import com.tahsinsayeed.faust.presentation.controller.Interactor;
import com.tahsinsayeed.faust.presentation.model.ViewModelStorage;

import java.io.*;

/**
 * Created by sayeed on 11/3/17.
 */
public class AddNoteInteractor implements Interactor {

    private final Repository<Note> noteRepository;
    private final Repository<Course> courseRepository;

    @Inject
    public AddNoteInteractor(Repository<Note> noteRepository, Repository<Course> courseRepository) {

        this.noteRepository = noteRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(Request request) {
        NewNoteRequest noteRequest = (NewNoteRequest) request;

        if (!courseRepository.idExists(noteRequest.courseId)) {
            System.out.println("Course does note exist");
            return;
        }

        File noteFile = new File(Config.get("config_dir") + File.separator + noteRequest.id);
        createFile(noteFile);

        Note note = Note.withId(noteRequest.id, noteRequest.title, noteRequest.courseId, noteFile);
        noteRepository.save(note);

        NoteDto noteDto = NoteDto.from(note);
        ViewModelStorage.getInstance().add(noteDto);

    }

    private void createFile(File noteFile) {
        try {
            noteFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
