package com.tahsinsayeed.faust.widget;

import com.sun.media.jfxmedia.logging.Logger;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;

public class PdfViewer {


    private String pdfUrl;
    private final WebView viewer;





    public static PdfViewer getInstance(){

       return getInstance(new WebView());
    }




    private String getBase64EncodedText() {
        try {
           byte[] data = Files.readAllBytes(new File(this.pdfUrl).toPath());
            System.out.println(Arrays.toString(data));

            return Base64.getEncoder().encodeToString(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private PdfViewer(WebView view){
        this.viewer = view;
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
        System.out.println(pdfUrl);
        String pdfDataInBase64 = getBase64EncodedText();
        this.viewer.getEngine().executeScript("openFileFromBase64('" + pdfDataInBase64 + "')");
    }

    public void display(Pane pane){
        pane.getChildren().add(viewer);
    }

    public WebView getViewer() {
        return viewer;
    }

    public static PdfViewer getInstance(WebView webView) {
        return new PdfViewer(webView);
    }
}
