package com.milan.service.ucenter;

import java.util.*;

public class user_base_info extends dllbase{
    //获取随机用户ID
    public static List<String>  getUids(int count){
        String sql="select uid from user_base_info  ORDER BY RAND() LIMIT "+count+";";
        List l = sql_execute.executeQueryList(sql);
        List<String> ls = new ArrayList<String>();
        for (int i=0;i<l.size();i++){
            ls.add(((Map)l.get(i)).get("uid").toString());
        }
        return  ls;
    }


}
