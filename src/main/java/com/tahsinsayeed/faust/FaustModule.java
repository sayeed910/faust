package com.tahsinsayeed.faust;

import com.google.common.eventbus.EventBus;
import com.google.inject.*;
import com.tahsinsayeed.faust.business.RequestBuilderImpl;
import com.tahsinsayeed.faust.business.entity.Course;
import com.tahsinsayeed.faust.business.interactor.*;
import com.tahsinsayeed.faust.persistence.memory.repository.*;
import com.tahsinsayeed.faust.presentation.controller.*;

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
        bind(EventBus.class).toInstance(new EventBus());
    }
}
