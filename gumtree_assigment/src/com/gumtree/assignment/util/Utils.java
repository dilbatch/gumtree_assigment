package com.gumtree.assignment.util;

import com.gumtree.assignment.exception.AssignmentException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dilyan B. on 14-5-22.
 */
public class Utils {
    private final static String pattern = "dd/MM/yy";

    public static Date getDateFromString(String string) throws AssignmentException{
        Date  date;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            throw new AssignmentException(e);
        }
        return date;
    }

    public static String createGetterNameFrom(String input){
        if (input != null && !input.equals("")){
            return "get" + Character.toUpperCase(input.charAt(0)) + input.substring(1);
        }
        return input;
    }

    public static String createSetterNameFrom(String input){
        if (input != null && !input.equals("")){
            return "set" + Character.toUpperCase(input.charAt(0)) + input.substring(1);
        }
        return input;
    }
}
