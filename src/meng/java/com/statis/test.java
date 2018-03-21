package com.statis;

import com.alibaba.fastjson.JSON;
import com.milan.net.MySqlHelper;

public class test {
    public static void main(String[] args) {

        System.out.println(JSON.toJSON(MySqlHelper.getTmmTestHelper().executeStr("select * from tmm_js_tj")));
    }
}
