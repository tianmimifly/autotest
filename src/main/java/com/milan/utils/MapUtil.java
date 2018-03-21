package com.milan.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    public static Map getMapByClass (Object obj) {
        Map map = new HashMap();
        Field[] f = obj.getClass().getDeclaredFields(); //获取该类的字段（public, protected, default (package) access, and private）
        for (Field ff : f)            //遍历字段
        {
            try {
                map.put(ff.getName(),ff.get(obj)==null?"":ff.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return  map;
    }
}
