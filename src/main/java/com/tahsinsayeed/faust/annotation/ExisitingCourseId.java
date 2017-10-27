package com.tahsinsayeed.faust.annotation;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sayeed on 10/27/17.
 */
@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
public @interface ExisitingCourseId {
}
