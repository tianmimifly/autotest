package com.milan.service.tradedb;

import com.milan.net.MySqlHelper;

import java.util.Map;

public class csp_activity_operation_record {
    public static Map getRowByBiz_id(String biz_id){
        String sql="SELECT * from tradedb1.csp_activity_operation_record t where t.biz_id="+biz_id+" ORDER BY ctime desc LIMIT 1";
        return MySqlHelper.getTradedbHelper().executeMap(sql);
    }
}
