package com.tahsinsayeed.studykit;

import com.tahsinsayeed.studykit.widget.PdfViewer;
import javafx.scene.web.WebView;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * This class supplies instantiated <link>PdfViewer</link> to the
 * application. The html pdfviewer takes some time to load. As such
 * if the javascript function to load pdf is executed immediately after
 * instantiating the Pdfviewer an exception is thrown since the function has
 * not been initialized. By instantiating pdfviewer way early than needed we
 * provide the underlying code to load properly
 */
public class PdfViewerFactory {
    private static Queue<PdfViewer> pdfViewerQueue;

    /**
     * This function initializes the queue that holds the instantiated
     * PdfViewer objects. It is important to call this method at the
     * beginning of the application.
     */
    public static void init(){
        pdfViewerQueue = new ArrayDeque<>(2);
        pdfViewerQueue.add(PdfViewer.getInstance());
        pdfViewerQueue.add(PdfViewer.getInstance());
    }

    public static PdfViewer get(WebView webView){
        PdfViewer viewer = pdfViewerQueue.remove();
        pdfViewerQueue.add(PdfViewer.getInstance(webView));
        return viewer;
    }
    public static PdfViewer get(){
        PdfViewer viewer = pdfViewerQueue.remove();
        pdfViewerQueue.add(PdfViewer.getInstance());
        return viewer;
    }


}
