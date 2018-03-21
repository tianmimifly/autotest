package com.milan.utils;

import java.util.Random;

public class RandomUtil {
    //获取范围内的随机值
    public static int getRandomNumber(int min,int max){
        Random rand = new Random();
        return  rand.nextInt(max - min + 1) + min;
    }
}
