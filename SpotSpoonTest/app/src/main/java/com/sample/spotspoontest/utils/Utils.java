package com.sample.spotspoontest.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Prince on 16-07-2017.
 */

public class Utils {


    public static String readJsonFileFromAssets(InputStream inputStream)
    {
        StringBuilder buf = new StringBuilder();
        InputStream json = inputStream;
        try {

            //getAssets().open("book/contents.json")
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }

            in.close();

        }catch (IOException e)
        {

        }
        return buf.toString();
    }
}
