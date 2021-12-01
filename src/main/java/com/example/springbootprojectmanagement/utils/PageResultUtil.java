package com.example.springbootprojectmanagement.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageResultUtil {

    public static Map<String,Object> getResult(Long total, List<?> records){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("count",total);
        result.put("data",records);
        result.put("code",0);
        result.put("msg","");
        return result;
    }
}
