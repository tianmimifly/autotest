package com.milan.utils;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class Assertion {

    public static boolean flag = true;

    public static List<Error> errors = new ArrayList<Error>();

    public static Boolean verifyEquals(Object actual, Object expected){
        flag =true;
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
       return flag;
    }

    public static Boolean verifyEquals(Object actual, Object expected, String message){
        flag =true;
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
        return  flag;
    }
    public static Boolean verifyNotEquals(Object actual, Object expected){
        flag =true;
        try{
            Assert.assertNotEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
        return flag;
    }
    public static Boolean verifyNotEquals(Object actual, Object expected, String message){
        flag =true;
        try{
            Assert.assertNotEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
        return  flag;
    }
}