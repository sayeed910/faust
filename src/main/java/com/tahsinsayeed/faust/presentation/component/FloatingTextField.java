package com.tahsinsayeed.faust.presentation.component;

import com.jfoenix.controls.JFXTextField;

/**
 * Created by sayeed on 10/26/17.
 */
public class FloatingTextField extends JFXTextField{
    public FloatingTextField(String value, String promptText){
        super(value);
        super.setPromptText(promptText);
        setLabelFloat(true);
    }

    public static FloatingTextField withPromptText(String value){
        return new FloatingTextField("", value);
    }
}
