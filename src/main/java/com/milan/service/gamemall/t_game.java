package com.milan.service.gamemall;

import java.util.Map;

public class t_game extends gamemall_base {
    //获取随机一条游戏
    public static Map getRandRow(){
        String sql="select * from t_game where operation_type=1 and is_delete=2 ORDER BY RAND() limit 1;";
        return sql_execute.executeMap(sql);
    }
}
