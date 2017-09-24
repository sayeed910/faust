package com.tahsinsayeed.studykit.widget;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Base64;
import java.util.Queue;
import java.util.logging.Level;

public class PdfViewer {


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
            e.printStackTrace();
        }

        return null;
    }

    private PdfViewer(){
        this.viewer = new WebView();
        String pdfViewerUrl = getClass().getResource("/web/pdfviewer/viewer.html").toExternalForm();
        WebEngine webEngine =  this.viewer.getEngine();
        webEngine.setUserStyleSheetLocation(getClass().getResource("/web/pdfviewer/web.css").toExternalForm());
        webEngine.setJavaScriptEnabled(true);
        webEngine.load(pdfViewerUrl);
    }

    private PdfViewer(String url){
        this.pdfUrl = url;
        this.viewer = new WebView();
        String pdfViewerUrl = getClass().getResource("/web/pdfviewer/viewer.html").toExternalForm();
        Logger.logMsg(3, pdfViewerUrl);
        WebEngine webEngine =  this.viewer.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webEngine.load(pdfViewerUrl);
    }

    public void loadPdf(String url){
        this.pdfUrl = url;
        String pdfDataInBase64 = getBase64EncodedText();

        this.viewer.getEngine().executeScript("openFileFromBase64('" + pdfDataInBase64 + "')");
    }

    public WebView getViewer() {
        return viewer;
    }
}
