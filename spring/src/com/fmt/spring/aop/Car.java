package com.fmt.spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 林其望 on 2017/7/7.
 */
@Component("car")
public class Car {

    @Value("本田")
    public String name;
    @Value("红色")
    public String color;


    public Car() {
    }
    public Car(String name,String color) {
        this.name=name;
        this.color=color;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
//        String dStr = "2017-08-14 03:00:00";
//        Date d = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            d = sdf.parse(dStr);
//        } catch (ParseException pe) {
//            System.out.println(pe.getMessage());
//        }
//        System.out.println(d);
//        System.out.println(d.getTime());
        System.out.println(getTimeDetailFull(1502704800000l));
    }


    public static String getTimeDetailFull(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(time);
        return dateString;
    }
}
