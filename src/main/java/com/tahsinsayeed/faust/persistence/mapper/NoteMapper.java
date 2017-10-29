package com.tahsinsayeed.faust.persistence.mapper;

import com.tahsinsayeed.faust.business.entity.Note;
import com.tahsinsayeed.faust.persistence.datamodel.NoteDataModel;
import com.tahsinsayeed.faust.persistence.repository.DataModelToEntityMapper;

import java.io.File;

/**
 * Created by sayeed on 10/28/17.
 */
public class NoteMapper implements DataModelToEntityMapper<NoteDataModel, Note> {
    @Override
    public Note map(NoteDataModel dataModel) {
        return Note.withId(dataModel.getId(), dataModel.getTitle(), dataModel.getParentCourseId(),
                new File(dataModel.getFilePath()));
    }
}
