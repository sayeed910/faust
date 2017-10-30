package com.tahsinsayeed.faust.business.interactor;

import com.tahsinsayeed.faust.config.Config;
import com.tahsinsayeed.faust.persistence.*;
import com.tahsinsayeed.faust.presentation.controller.Interactor;

import java.io.File;

/**
 * Created by sayeed on 10/30/17.
 */
public class FirstRunInteractor implements Interactor {
    @Override
    public void execute(Request request) {
        makeConfigDir();
        Database.getInstance(DBConnection.getInstance()).create();
    }

    private void makeConfigDir() {
       boolean result = new File(Config.get("config_dir")).mkdir();
        System.out.println(result);
    }
}
