package com.milan;

import com.milan.net.MySqlHelper;

public class test_sql {
    public test_sql() {
    }

    public static void main(String[] args) {
        testbatch();
    }
    public static void  testbatch(){
        String strSql="set @activity_id='1515487537751892'; -- 开服活动ID\n" +
                "delete from csp_coupon_config where  config_id like '300022%';\n" +
                "UPDATE csp_activity t set t.activity_status=2,t.balance=1000,t.begin_time=UNIX_TIMESTAMP(date_format(DATE_SUB(NOW(),INTERVAL +1 DAY), '%Y%m%d'))   ,t.end_time=UNIX_TIMESTAMP(date_format(DATE_SUB(NOW(),INTERVAL -10 DAY), '%Y%m%d'))  where activity_id=@activity_id;\n" +
                "INSERT INTO `csp_coupon_config` (`config_id`, `activity_id`, `game_id`, `os_type`, `value`, `num_limit`, `valid_days`, `config_status`, `creator`, `remark`, `ctime`, `utime`) VALUES ('300022226',@activity_id, '1501638381223898','1', '5', '2', '7', '1', '111', NULL, '1515399562', '1515399690');\n"+
                "select * from csp_activity limit 1;\n" ;
        System.out.println("result");
        System.out.println(MySqlHelper.getTradedbHelper().executeSqlBatch(strSql));
    }
}
