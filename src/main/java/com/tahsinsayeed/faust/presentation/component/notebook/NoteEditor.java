package com.tahsinsayeed.faust.presentation.component.notebook;

import com.google.common.eventbus.EventBus;
import com.google.common.io.Files;
import com.tahsinsayeed.faust.presentation.event.SaveNoteEvent;
import com.tahsinsayeed.faust.presentation.model.NoteViewModel;
import javafx.concurrent.Worker;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.web.*;
import javafx.stage.FileChooser;
import netscape.javascript.JSObject;

import java.io.*;

public class NoteEditor extends VBox {
    private static final String QUILL_URL = NoteEditor.class.getResource("/web/quill/quill.html").toExternalForm();
    private EventBus mainEventBus;
    private NoteViewModel noteDataModel;
    private WebView viewer;
    private WebEngine engine ;
    private TextField titleInput;

    NoteEditor(EventBus eventBus, NoteViewModel noteDataModel) {
        this.mainEventBus = eventBus;
        this.noteDataModel = noteDataModel;
        this.viewer = new WebView();
        this.engine = viewer.getEngine();

        titleInput = new TextField(noteDataModel.getTitle().get());
        getChildren().addAll(new HBox(new Text("Title"), titleInput), viewer);
        setSpacing(20);

        init();
    }

    NoteEditor(){
        this.viewer = new WebView();
        this.engine = viewer.getEngine();

        titleInput = new TextField();
        getChildren().addAll(new HBox(new Text("Title"), titleInput), viewer);
        setSpacing(20);

        init();
    }



    public void loadContent() {
        String content = noteDataModel.getContent().get();
        if (!content.isEmpty())
            load(content);
    }

    private void init() {
        WebEngine webEngine = viewer.getEngine();
        webEngine.load(QUILL_URL);
        webEngine.getLoadWorker().stateProperty().addListener(
                (ov, oldState, newState) -> {
                    if(newState == Worker.State.SUCCEEDED){
                        JSObject window = (JSObject)webEngine.executeScript("window");
                        window.setMember("handler", this);
                    }
                });

        JSObject window = (JSObject)webEngine.executeScript("window");
        window.setMember("handler", this);
    }

    public String chooseImage(){

        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        String imageMimeType = "image/jpeg";
        String data = "";


        try {
            data = "data:" + imageMimeType + ";base64," +
                    javax.xml.bind.DatatypeConverter.printBase64Binary(Files.toByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        engine.executeScript("insertImage('" + data + "')");
        return file.getAbsolutePath();
    }

    public void display(String data){
        data = data.replaceAll("\\\\","\\\\\\\\");
        System.out.println(data);
    }

    public void save(String content){
        System.out.println("js called");
        content = content.replaceAll("\\\\","\\\\\\\\");
        mainEventBus.post(new SaveNoteEvent(
                noteDataModel.getId().get(),
                noteDataModel.getParentCourseId().get(),
                titleInput.getText().trim(),
                content
        ));
    }

    public void load(String data){
        engine.executeScript("load('" + data + "')");
    }

    public void setMainEventBus(EventBus mainEventBus) {
        this.mainEventBus = mainEventBus;
    }

    public void setNoteDataModel(NoteViewModel noteDataModel) {
        this.noteDataModel = noteDataModel;
        titleInput.setText(noteDataModel.getTitle().get());
    }
}
