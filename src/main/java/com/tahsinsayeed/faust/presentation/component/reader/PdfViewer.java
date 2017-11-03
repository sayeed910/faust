package com.tahsinsayeed.faust.presentation.component.reader;

import javafx.scene.layout.StackPane;
import javafx.scene.web.*;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;

public class PdfViewer extends StackPane {

    private static final String PDF_READER_URL = PdfViewer.class.getResource("/web/pdfviewer/viewer.html").toExternalForm();

    private String pdfUrl;
    private final WebView viewer;

    public static PdfViewer getInstance(){
       return new PdfViewer();
    }




    private String getBase64EncodedText() {
        try {
           byte[] data = Files.readAllBytes(new File(this.pdfUrl).toPath());
            return Base64.getEncoder().encodeToString(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private PdfViewer(){
        this.viewer = new WebView();
        WebEngine webEngine =  this.viewer.getEngine();
        getChildren().add(viewer);
        webEngine.setUserStyleSheetLocation(getClass().getResource("/web/pdfviewer/web.css").toExternalForm());
        webEngine.setJavaScriptEnabled(true);
        webEngine.load(PDF_READER_URL);
    }


    public void loadPdf(String url){
        this.pdfUrl = url;
        System.out.println(pdfUrl);
        String pdfDataInBase64 = getBase64EncodedText();
        this.viewer.getEngine().executeScript("openFileFromBase64('" + pdfDataInBase64 + "')");
    }


}
