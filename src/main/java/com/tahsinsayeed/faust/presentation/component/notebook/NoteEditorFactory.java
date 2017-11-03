package com.tahsinsayeed.faust.presentation.component.notebook;

import com.google.common.eventbus.EventBus;
import com.tahsinsayeed.faust.presentation.model.NoteViewModel;

import java.util.*;

/**
 * This class supplies instantiated <link>NoteEditor</link> to the
 * application. The html richtext editor takes some time to load. As such
 * if the javascript function to load pdf is executed immediately after
 * instantiating the editor an exception is thrown since the function has
 * not been initialized. By instantiating editor way early than needed we
 * provide the underlying code to load properly
 */
public class NoteEditorFactory {
    private static Queue<NoteEditor> noteEditors;

    /**
     * This function initializes the queue that holds the instantiated
     * NoteEditor objects. It is important to call this method at the
     * beginning of the application.
     */
    public static void init(){
        noteEditors = new ArrayDeque<>(2);
        noteEditors.add(new NoteEditor());
        noteEditors.add(new NoteEditor());
    }


    public static NoteEditor get(EventBus bus, NoteViewModel model){
        NoteEditor editor = noteEditors.remove();
        editor.setMainEventBus(bus);
        editor.setNoteDataModel(model);

        noteEditors.add(new NoteEditor());
        return editor;
    }


}
