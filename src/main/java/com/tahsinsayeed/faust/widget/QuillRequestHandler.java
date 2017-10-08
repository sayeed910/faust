package com.tahsinsayeed.faust.widget;

import com.google.common.io.Files;
import javafx.scene.web.WebEngine;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class QuillRequestHandler {
    private final WebEngine engine;

    public QuillRequestHandler(WebEngine engine) {
        this.engine = engine;
    }

    public String imageToText(){
        return "";
    }

    public String chooseImage(){
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        String path = file.getAbsolutePath();
        System.out.println(file.toURI());
        String imageMimeType = "image/jpeg";
        String data = "";


        try {
            data = "data:" + imageMimeType + ";base64," +
                    javax.xml.bind.DatatypeConverter.printBase64Binary(Files.toByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data.length());
        engine.executeScript("insertImage('" + data + "')");
        return file.getAbsolutePath();
    }
}
