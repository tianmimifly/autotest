package com.milan.service.tradedb;

import java.util.List;

public class csp_coupon_use_record  extends dllbase{
    public static List getListByUid(String uid){
        String sql="select * from tradedb1.csp_coupon_use_record where uid="+uid+"  ORDER BY ctime DESC;";
        return sql_execute.executeQueryList(sql);
    }
}
