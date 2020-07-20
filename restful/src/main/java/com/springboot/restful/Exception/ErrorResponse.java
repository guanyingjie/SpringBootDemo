package com.springboot.restful.Exception;

//包装异常信息,返回给前端

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private int code;
    private int status;
    private String message;
    private String path;
    private Instant timestamp;
    private HashMap<String, Object> data = new HashMap<>();

    public ErrorResponse() {
    }

    public ErrorResponse(BaseException ex, String path) {
        this(ex.getError().getCode(),ex.getError().getStatus().value(),ex.getError().getMessage(),path,ex.getData());
    }

    public ErrorResponse(int code, int status, String message, String path, HashMap<String, Object> data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now();
        if(!ObjectUtils.isEmpty(data)){
            this.data.putAll(data);
        }
    }

    @Override
    public String toString() {
        return "ErrorReponse{" +
                "code=" + code +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
    //    private String message;
//    private String errorTypeName;
//    public ErrorResponse(Exception e){
//        this(e.getClass().getName(),e.getMessage());
//
//    }
//
//    public ErrorResponse(String errorTypeName, String message) {
//        this.errorTypeName = errorTypeName;
//        this.message = message;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getErrorTypeName() {
//        return errorTypeName;
//    }
//
//    public void setErrorTypeName(String errorTypeName) {
//        this.errorTypeName = errorTypeName;
//    }
}
