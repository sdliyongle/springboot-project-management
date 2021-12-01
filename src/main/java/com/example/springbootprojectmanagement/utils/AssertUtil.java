package com.example.springbootprojectmanagement.utils;


import com.example.springbootprojectmanagement.exceptions.ParamsException;

public class AssertUtil {


    public  static void isTrue(Boolean flag,String msg){
        if(flag){
            throw  new ParamsException(msg);
        }
    }

}
