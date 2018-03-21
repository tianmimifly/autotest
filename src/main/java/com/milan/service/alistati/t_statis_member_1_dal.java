package com.milan.service.alistati;

import com.milan.net.MySqlHelper;

public  class t_statis_member_1_dal {
    public  static  String getList(){
        String sql ="select * from t_statis_member_1 where member_uid =2126630";
        return MySqlHelper.getAlistatiHelper().executeQueryList(sql).toString();
    }
}
