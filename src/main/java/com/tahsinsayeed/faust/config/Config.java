package com.tahsinsayeed.faust.config;

import com.tahsinsayeed.faust.util.ContentValues;

/**
 * Created by sayeed on 10/30/17.
 */
public class Config {
    private static ContentValues config = new ContentValues("config_dir", "faust_dir");

    public static String get(String key){
        return config.get(key);
    }

}
