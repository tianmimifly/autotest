package com.milan.utils;

import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectionUtil {
    private static  String getTestDesc(Object obj,String methodName){
        String str="";
        try {
            Method m = obj.getClass().getMethod(methodName);
            str=obj.getClass().getName()+"..."+m.getName();
            if (m.getAnnotations().length> 0 ){
                Annotation annotation =m.getAnnotations()[0];
                Test te = (Test) annotation;
                str+="["+te.description()+"]";
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static  String getTestDesc2(Object obj){
        String str="";
        try {
            String current=Thread.currentThread().getStackTrace()[3].getMethodName();
            Method m = obj.getClass().getMethod(current);
            str=obj.getClass().getName()+"..."+m.getName();
            if (m.getAnnotations().length> 0 ){
                Annotation annotation =m.getAnnotations()[0];
                Test te = (Test) annotation;
                str+="["+te.description()+"]";
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return str;
    }
}
