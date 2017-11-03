package com.tahsinsayeed.faust.config;

import com.google.common.eventbus.EventBus;
import com.google.inject.*;
import com.tahsinsayeed.faust.business.interactor.InteractorFactoryImpl;
import com.tahsinsayeed.faust.business.RequestBuilderImpl;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.interactor.*;
import com.tahsinsayeed.faust.persistence.repository.*;
import com.tahsinsayeed.faust.presentation.controller.*;
import com.tahsinsayeed.faust.presentation.entitycreator.assignmentcreator.AssignmentCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.bookcreator.BookCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.classcreator.ClassCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.examcreator.ExamCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.holidaycreator.HolidayCreator;
import com.tahsinsayeed.faust.presentation.entitycreator.notecreator.NoteCreator;
import com.tahsinsayeed.faust.presentation.event.Bus;

/**
 * Created by sayeed on 10/26/17.
 */
public class FaustModule extends AbstractModule {
    @Override
    public void configure() {
        bind(RequestBuilder.class).to(RequestBuilderImpl.class);
        bind(RepositoryFactory.class).to(RepositoryFactoryImpl.class);
        bind(InteractorFactory.class).to(InteractorFactoryImpl.class);
        bind(new TypeLiteral<Repository<Course>>(){}).to(CourseRepository.class);
        bind(EventBus.class).toInstance(Bus.get());
        bind(ExamCreator.class).toProvider(ExamCreationViewProvider.class);
        bind(AssignmentCreator.class).toProvider(AssignmentCreationViewProvider.class);
        bind(BookCreator.class).toProvider(BookCreationViewProvider.class);
        bind(ClassCreator.class).toProvider(ClassCreationViewProvider.class);
        bind(HolidayCreator.class).toProvider(HolidayCreationViewProvider.class);
        bind(NoteCreator.class).toProvider(NoteCreationViewProvider.class);
    }


}
