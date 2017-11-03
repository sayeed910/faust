package com.tahsinsayeed.faust.presentation.event;

import com.tahsinsayeed.faust.presentation.model.ExamViewModel;

/**
 * Created by IMON on 11/3/2017.
 */
public class ExamItemSelected {
    public final ExamViewModel examViewModel;

    public ExamItemSelected(ExamViewModel examViewModel) {
        this.examViewModel = examViewModel;
    }
}
