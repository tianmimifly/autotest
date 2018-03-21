package com.milan.utils;

import com.milan.entity.DBEntity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties properties;
    private static DBEntity getDBByKeys(String keys){
        DBEntity dbEntity =new DBEntity();
        dbEntity.setUrl(properties.getProperty(keys+".url"));
        dbEntity.setUsername(properties.getProperty(keys+".username"));
        dbEntity.setPassword(properties.getProperty(keys+".password"));
        return  dbEntity;
    }
    public static DBEntity getGamemallDB(){
        return getDBByKeys("gamemall.datasource");
    }
    public static DBEntity getUcenterDB(){
        return getDBByKeys("ucenter.datasource");
    }
    public static DBEntity getTradedb1DB(){
        return getDBByKeys("tradedb1.datasource");
    }
    public static DBEntity getAlistatiDB(){
        return getDBByKeys("alistati.datasource");
    }
    public static DBEntity getMyDB(){
        return getDBByKeys("my.datasource");
    }
    static {
        properties = new Properties();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("config/application.properties"));
            properties.load(bufferedReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
