package com.ujiuye.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-17 19:45
 */
public class MyDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String time) {
        String patten = "yyyy/MM/nn";
        if (time.contains("-")){
            patten = "yyyy-MM-nn";
        }
        if (time.contains(":")){
            patten += " hh:mm:ss";
        }
        try {
            Date date = new SimpleDateFormat(patten).parse(time);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}
