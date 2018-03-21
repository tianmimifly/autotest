package com.milan.service.gamemall;

import com.milan.net.MySqlHelper;

public class t_mer_dal {
    public  static  String getList(){
        String sql ="select * from t_mer where uid =2126630";
        return MySqlHelper.getGamemallHelper().executeQueryList(sql).toString();
    }
}
