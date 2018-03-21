package com.milan.utils;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
public class AssertUtil {
//    public static boolean flag = true;
//    public static List<Error> errors = new ArrayList<Error>();
    public static boolean assertEquals(Object actual,Object expected,String message){
       boolean b = false;
        try {
            Assert.assertEquals(actual, expected,message);
            b=true;
        } catch (AssertionError e) {
            b =false;
            //throw e;
        }
      return b;
    }
    public static  boolean assertNotEquals(Object actual,Object expected,String message){
        boolean b = false;
        try {
            Assert.assertNotEquals(actual, expected,message);
            b=true;
        } catch (AssertionError e) {
            b =false;
            //throw e;
        }
        return b;
    }

}
