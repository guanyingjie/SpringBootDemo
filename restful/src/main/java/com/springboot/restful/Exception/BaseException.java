package com.springboot.restful.Exception;

import com.oracle.javafx.jmx.SGMXBean;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

//其他异常类的父类
public class BaseException extends RuntimeException {
    private final ErrorCode error;
    private final HashMap<String,Object> data = new HashMap<>();

    public BaseException(ErrorCode error, Map<String,Object>data) {
        super(error.getMessage());
        this.error = error;
        if(!ObjectUtils.isEmpty(data)){
            this.data.putAll(data);
        }
    }
    protected BaseException(ErrorCode error,Map<String,Object>data,Throwable cause){
        super(error.getMessage());
        this.error = error;
        if(!ObjectUtils.isEmpty(data)){
            this.data.putAll(data);
        }

    }

    public ErrorCode getError() {
        return error;
    }

    public HashMap<String, Object> getData() {
        return data;
    }
}
