package com.milan.service.tradedb;

import com.milan.net.MySqlHelper;

import java.util.List;

public class csp_coupon extends dllbase{
    //返回用户是否有可用代金券
    public static int hasAvailableCoupon(String uid){
        String sql="select count(*) from tradedb1.csp_coupon where uid="+uid+" and coupon_status=1 and expire_time > UNIX_TIMESTAMP(NOW());";
        return MySqlHelper.getTradedbHelper().executeInt(sql);
    }
    //返回用户代金券
    public static List getListByUid(String uid,String game_id){
        String sql="select * from tradedb1.csp_coupon where uid="+uid+" and coupon_status=1  and game_id="+game_id+" ORDER BY ctime DESC;";
        return MySqlHelper.getTradedbHelper().executeQueryList(sql);
    }
    public static List getListByUid(String uid){
        String sql="select * from tradedb1.csp_coupon where uid="+uid+"  ORDER BY ctime DESC;";
        return MySqlHelper.getTradedbHelper().executeQueryList(sql);
    }
    //设置为过期
    //UNIX_TIMESTAMP(date_format(NOW(),'%Y-%m-%d'))  设置过期
    //UNIX_TIMESTAMP(date_format(DATE_SUB(NOW(),INTERVAL -1 DAY), '%Y%m%d')) 设置未过期
    public static void setExpire_time(String uid,String expire_time,String game_id){
        String sql="UPDATE tradedb1.csp_coupon t set t.expire_time = "+expire_time+" where uid="+uid+" and game_id=\"+game_id+\";";
        MySqlHelper.getTradedbHelper().execute(sql);
    }
    //设置状态
    public static  void  setStatus(String uid,int status,String game_id){
        String sql ="UPDATE tradedb1.csp_coupon t set t.coupon_status ="+status+" where uid="+uid+" and game_id="+game_id+";";
        MySqlHelper.getTradedbHelper().execute(sql);
    }

    //删除用户所有的代金券
    public static void  deleteByUid(String uid){
        String sql="delete from   tradedb1.csp_coupon where uid="+uid;
        sql_execute.execute(sql);
        sql="delete from   tradedb1.csp_coupon_use_record where uid="+uid;
        sql_execute.execute(sql);
    }

}
