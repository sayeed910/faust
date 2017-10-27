package com.tahsinsayeed.faust.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sayeed on 10/25/17.
 */
public class ContentValuesTest {

    @Test
    public void creation() throws Exception{
        ContentValues contentValues = new ContentValues(
                "key1", "value1",
                "key2", "value2",
                "key3", "value3");

        assertEquals(contentValues.get("key2"), "value2" );
    }

}