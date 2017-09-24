package com.tahsinsayeed.studykit.widget;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class Notebook {
    private WebView viewer;
    private static final String QUILL_URL = Notebook.class.getClass().getResource("/web/quill/quill.html").toExternalForm();
    private QuillRequestHandler quillHandler;

    private Notebook() {
        this(new WebView());
    }

    private Notebook(WebView view) {
        viewer = view;
        quillHandler = new QuillRequestHandler(viewer.getEngine());


    }

    public static Notebook create(WebView view) {
        return new Notebook(view);
    }

    public void loadNoteBook() {
        Logger.logMsg(3, "Quill Viewer located at: " + QUILL_URL);
        WebEngine webEngine = viewer.getEngine();
        webEngine.load(QUILL_URL);
        webEngine.getLoadWorker().stateProperty().addListener(
                (ov, oldState, newState) -> {
                    if(newState == Worker.State.SUCCEEDED){
                        JSObject window = (JSObject)webEngine.executeScript("window");
                        window.setMember("handler", quillHandler);
                    }
                });


        JSObject window = (JSObject)webEngine.executeScript("window");
        window.setMember("handler", quillHandler);
    }
}
