package com.mmall.common;

/**
 * Created by 林其望 on 2017/11/3.
 */
public enum  ResponseCode {
    SUCCESS(0,"success"),
    ERROR(1,"error"),
    NEED_LOGIN(10,"need_login"),
    ILLEGAL_AGRUMENT(2,"illegal_agrument");

    private final int code;
    private final String desc;
    ResponseCode(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
