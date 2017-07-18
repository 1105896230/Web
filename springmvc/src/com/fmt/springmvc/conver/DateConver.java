package com.fmt.springmvc.conver;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 否命题 on 2017/7/14.
 */
public class DateConver implements Converter<String,Date>{

    @Override
    public Date convert(String s) {
        try {
            if (null!=s){
                DateFormat format=new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
                return format.parse(s);
            }
        }catch (Exception e){

        }
        return null;
    }
}
