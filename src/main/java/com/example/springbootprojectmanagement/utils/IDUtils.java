package com.example.springbootprojectmanagement.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author ZengQi
 * @description: TODO
 * @date 2021/11/24 0024 14:43
 */
public class IDUtils {

    public static final Logger logger = LoggerFactory.getLogger(IDUtils.class);

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
        logger.debug("test");
    }
}
