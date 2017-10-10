package com.tahsinsayeed.faust.ui;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class TextEditor {
    private WebView viewer;
    private static final String QUILL_URL = TextEditor.class.getClass().getResource("/web/quill/quill.html").toExternalForm();
    private QuillRequestHandler quillHandler;

    private TextEditor() {
        this(new WebView());
    }

    private TextEditor(WebView view) {
        viewer = view;
        quillHandler = new QuillRequestHandler(viewer.getEngine());


    }

    public static TextEditor create(WebView view) {
        return new TextEditor(view);
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
