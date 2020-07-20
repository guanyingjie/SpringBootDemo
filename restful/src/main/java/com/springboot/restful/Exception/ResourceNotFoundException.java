package com.springboot.restful.Exception;

import java.util.Map;

public class ResourceNotFoundException extends BaseException{
    public ResourceNotFoundException(Map<String,Object>data){
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }



    //    private String message;
//
//    public ResourceNotFoundException() {
//        super();
//    }
//
//    public ResourceNotFoundException(String message) {
//        super(message);
//        this.message = message;
//    }
//
//    @Override
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
}
