package com.milan.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassUtil {
    public static  <T> void setValue(T objClass,String fildName, Object value) throws NoSuchFieldException {
        T bean = null;
        Field field = null;

        //if (value!=null && !value.equals("")) {
            try {
                //field = objClass.getClass().getDeclaredField(fildName);
                //if (field != null) {
                PropertyDescriptor pd = new PropertyDescriptor(fildName, objClass.getClass());
                Method method = pd.getWriteMethod();
                method.invoke(objClass, value);
                //  field.set(objClass, value);
                // }
            } catch (Exception e) {

            }
        //}


    }
    public static List<String> getFieldName(Class<?> cls) {
        List<String> list = new ArrayList<>();
        // 获取此类所有声明的字段
        Field[] field = cls.getFields();
        // 循环此字段数组，获取属性的值
        for (int i = 0; i < field.length && field.length > 0; i++) {
            // 值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查.
            field[i].setAccessible(true);
            // field[i].getName() 获取此字段的名称
            // field[i].get(object) 获取指定对象上此字段的值
            String name = field[i].getName();
            list.add(name);
        }
        return list;
    }
}
