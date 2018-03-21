package com.milan.service.tradedb;

import java.util.List;
import java.util.Map;

public class csp_activity_capital_flow extends dllbase {
    public static Map getRowByActivityID(String activity_id){
        String sql="SELECT * from tradedb1.csp_activity_capital_flow t where t.account_id="+activity_id+" ORDER BY ctime desc LIMIT 1";
        return sql_execute.executeMap(sql);
    }
    public static List getListByActivityID(String activity_id,int limit){
        String sql="SELECT * from tradedb1.csp_activity_capital_flow t where t.account_id="+activity_id+" ORDER BY ctime desc LIMIT "+limit+"";
        return sql_execute.executeQueryList(sql);
    }
}
