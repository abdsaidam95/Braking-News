package com.haroonstudios.newsapitutorial.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppConstants
{
    public static final String API_KEY = "b2f868ee29a64c3bb200636a22e70181";


    public static Date parse(String input) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

        if(input.endsWith("Z"))
        {
            input = input.substring(0,input.length() -1) + "GMT-00:00";

        }
        else
        {
            int inset = 6;

            String s0 = input.substring(0,input.length() - inset);
            String s1 = input.substring(input.length() - inset, input.length());
            input = s0 + "GMT" +s1;
        }

        return df.parse(input);

    }
}
