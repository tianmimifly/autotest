package com.milan.utils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.util.Map;

public class LogUtil {
    private static Logger logger ;
    static {
        String filePath = "config/log4j.properties";
        logger = Logger.getLogger("TestProject");
        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
    }
    public static void logInfo(String message) {
        logger.info(message);
    }
    public static void beginCase(String methodName){
        logInfo("-------执行用例-------------------------");
        logInfo(methodName);
    }
    public static void beginCase2(Object obj){
        logInfo("-------执行用例-------------------------");
        logInfo(ReflectionUtil.getTestDesc2(obj));
    }
    public static void begunCaseByExcel(Map m){
        logInfo("---------【执行用例】------------");
        logInfo(m.get("caseDesc"));
    }
    public static  void  logInfo(Object obj){
        logger.info(obj.toString());
    }
    public static  void  logInfo(String desc,Object obj){
        logger.info(desc);
        logger.info(obj==null?"无":obj.toString());
    }
    public static void logError(String message) {
        logger.error(message);
    }
    public static void logWarn(String message) {
        logger.warn(message);
    }
    public static void logDebug(String message){
        logger.debug(message);
    }

}