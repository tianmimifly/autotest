package com.statis;

import com.alibaba.fastjson.JSON;
import com.milan.net.MySqlHelper;
import com.milan.utils.RandomUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jiesuan_add_bak {
    public static void main(String[] args) {
        //step_02();
        statis();

    }
    //增加t_mer_revenue_ration分成设置
    public static void step_01(){
        String str_temp="set @min=0;\n" +
                "set @max =5;\n" +
                "set @id=(SELECT (MAX(id)+1) from t_mer_revenue_ration);\n" +
                "set @leader_uid =${leader_uid};\n" +
                "SET @game_id ='${game_id}';\n" +
                "set @outter_game_id='${outter_game_id}';\n" +
                "INSERT INTO `gamemall`.`t_mer_revenue_ration` (`id`, `leader_uid`, `game_id`, `outter_game_id`, `revenue_ration`, `ctime`, `utime`) VALUES (@id, @leader_uid, @game_id, @outter_game_id, FLOOR(RAND() * @max-@min+1)+@min,UNIX_TIMESTAMP(NOW()) ,UNIX_TIMESTAMP(NOW()));\n";

        String t_game_sql="select game_id,outter_game_id,revenue_ration from  t_game ;";
        String leader_uid_sql="select DISTINCT(leader_uid) from t_mer_group where leader_uid NOT in (select DISTINCT(leader_uid) from t_mer_revenue_ration );";
        List game_list = MySqlHelper.getGamemallHelper().executeQueryList(t_game_sql);
        List leader_list=  MySqlHelper.getGamemallHelper().executeQueryList(leader_uid_sql);
        for(Object o :leader_list){
            Map m =(Map) o;

            for (Object ogame : game_list) {
                Map mgame   = (Map) ogame;
                String str =str_temp.replace("${leader_uid}",m.get("leader_uid").toString());
                str =str.replace("${game_id}",mgame.get("game_id").toString());
                str =str.replace("${outter_game_id}",mgame.get("outter_game_id").toString());
                MySqlHelper.getGamemallHelper().executeSqlBatch(str);
               // System.out.println(str);
                //System.out.println(str_temp);
            }
        }
    }
    //增加index_order_info 和coupon
    public static void step_02(){
        String game_binding_sql="select uid,outter_game_id from user_game_binding where chl_id in (\n" +
                "'test',\n" +
                "'26e141fe-b9ac-4764-ad5e-8f5071fa8c9d',\n" +
                "'3052bd02-03ee-43c3-b8b8-00c0d8baac22',\n" +
                "'ea39d37b-2f3b-4137-b75f-126a1e7522d2',\n" +
                "'addec2f2-20d8-413f-8680-83d739d23f2e',\n" +
                "'d9da96b2-e09a-4f64-84a7-5ee453826e4a',\n" +
                "'d3d3a138-b609-44e6-b983-f035013f0a27',\n" +
                "'452f1fdd-1246-4b4d-b768-031fd83215c53',\n" +
                "'2126327',\n" +
                "'2126329',\n" +
                "'2126332',\n" +
                "'9ec9bc34-d5f4-4bc9-90e8-175fd26bf988',\n" +
                "'bc669054-80f2-43b6-a07f-a950ed70138f',\n" +
                "'1ba62d1d-0b73-429e-87e4-d37d47acb203',\n" +
                "'4745dfaa-1c1a-4c8f-ad31-c629b397a273',\n" +
                "'e34d6ec9-db86-4c54-bc7d-7872dfc92127',\n" +
                "'19651af6-ecc6-49e2-a973-e852aa1c5dba',\n" +
                "'cbaa8447-59b3-4c40-9a77-29be60cd0a07',\n" +
                "'ec5c1076-a37c-4151-b451-46ab386df524',\n" +
                "'df059da7-c94e-44a1-806f-6de462c94e8a',\n" +
                "'30d34c67-ab7c-4cc3-be4c-f81f06067aa4',\n" +
                "'f9c0f9bb-1d0e-413c-a425-4e1be7a58858',\n" +
                "'452f1fdd-1246-4b4d-b768-031fd83212c5',\n" +
                "'037275cd4a5f30b4a19bab1c6c4f462f',\n" +
                "'dd9ff10dd824261c4bc8fb789acdd55c',\n" +
                "'8ebcf37c9b3f08f425a9addb0d8b0cb3',\n" +
                "'9dcaedd95c85e083b160717d02d78505',\n" +
                "'2b6af33eec4ffa977c810dce0d71778a',\n" +
                "'c69009b9271dec3954551052a43025c1',\n" +
                "'3c405e38c797bac6147e16c0c6daa059',\n" +
                "'49fbc30919b5d17f648a9ec1b1744c98',\n" +
                "'e15c6dca14f07dd9199660df2e112e27',\n" +
                "'096c66290ac0c2e7916dba73a08e1805',\n" +
                "'e3bd2c7b7971a7e47584834c41d02688',\n" +
                "'8f09ef8405234076f5c4ab7a94f11273',\n" +
                "'6b3381d768716665e1fe75c3b54359db',\n" +
                "'f5c06fc46ae37faea0680e0d0026b4ef',\n" +
                "'4dd3da4cf243d4a4b08a70b67fe22b09',\n" +
                "'a12e77421355e77133f2244d7c13bff9',\n" +
                "'3bb2f618235fa8785e28be395c0901f9',\n" +
                "'703f9edc7b489c4931d668602a386eda',\n" +
                "'ad48588725e7e72b4b3855be5e4993bc',\n" +
                "'fba84d8a32af4c96ba26ac284a45e66f',\n" +
                "'e9ad45a3045ecf4cbb67fcfb9c17e5aa',\n" +
                "'2f5c2c9a4f822abbf2c8d178b8f3cb47',\n" +
                "'caf5b661ce1caab0bf112983395e031c',\n" +
                "'dab1d7f0b32189db1f9195ff4ed61d64',\n" +
                "'4e80098d-4be9-435a-8be2-d3986a9fd051',\n" +
                "'db89e898-1d51-45d8-8295-3dd99d728bcc',\n" +
                "'b480bca9-33a0-42bc-a600-8dafd8e50cdf',\n" +
                "'f753c390-b668-466e-9531-7ab721efb983',\n" +
                "'5c2dca45-5414-40a9-a566-f9a807594cef',\n" +
                "'5347e632-89ee-4853-bdfa-0f3f9b36a744',\n" +
                "'33b0e742-d7d8-4dda-b12c-06a8d110c46a',\n" +
                "'4217005c-49cd-4166-99d5-73bd4391d10c',\n" +
                "'e4ab27b9-f562-4569-a861-100339db7e9c',\n" +
                "'a60414cf-9cf3-4b8c-8b58-a1a505447854',\n" +
                "'b2a641fa-697d-40b7-b5a2-88088ca8a349',\n" +
                "'901bd8e6-706f-445e-9cbb-55e203f4a1b2',\n" +
                "'c2523947-265d-4318-be14-e7cb7e3b0cbc',\n" +
                "'71e85eff-c4f2-4aa5-a74e-c46cf6ae727c',\n" +
                "'a1bfa1f2-f25a-4369-9979-0224fd736044',\n" +
                "'7d7b2d12-95aa-4014-b988-9752d380e11f',\n" +
                "'17e079d5-5eb3-44d6-a9b5-9e1603d8493d',\n" +
                "'ae2c3755-30fd-4dba-a23d-65d6a753d05e',\n" +
                "'a3a3e7c9-0057-488f-be23-054732aa3899',\n" +
                "'539739dd-e071-4ee7-a738-8cb328fa08d4',\n" +
                "'8fe9f1db-8992-43de-b48c-cdb7a0183c7d',\n" +
                "'00b606a0-3bad-4fb3-ac22-c8f22c8826b0',\n" +
                "'8b66d03b-228b-42a2-b6aa-9a71d41e2748',\n" +
                "'02b7e3cd-8a2f-4bc8-93bd-8b8df748e984',\n" +
                "'8c46be38-f5eb-48c6-ad35-aa5893e18498',\n" +
                "'d1547860-a038-4534-9936-9d87738a71ad',\n" +
                "'9207c81b-aa5b-4d35-9fa2-c705a90cc4e0'\n" +
                ") ;";

        String index_order_sql="set @uid=${uid};\n" +
                "set @outter_game_id='${outter_game_id}'; \n" +
                "set @order_price=${order_price};\n" +
                "set @pay_price=${pay_price};\n" +
                "set @utime = UNIX_TIMESTAMP(DATE_SUB(NOW(),INTERVAL +3 DAY));\n" +
                "set @chl_id='999';\n" +
                "set @open_id= MD5(UNIX_TIMESTAMP());\n" +
                "set @create_date = date_format(DATE_SUB(NOW(),INTERVAL +3 DAY), '%Y%m%d');\n" +
                "set @order_status = '4';\n" +
                "set @delivery_status = '3';\n" +
                "set @order_id =(SELECT MAX(order_id)+1 from index_order_info);\n" +
                "set @choose_pay_way=${choose_pay_way}; -- 支付方式(1-支付宝,2-微信,3-银联,4-ios内支付,5-喵点)\n" +
                "insert into index_order_info(order_id,buyer_uid,seller_uid,order_price,pay_price,order_status,delivery_status,customer_id,create_date,pay_time,chl_id,game_id,goods_category_id,goods_type_id,remark,order_end_time,choose_pay_way,refund_status,sdk_game_id,publish_chl,order_os,imei_androidid,ry_app_key,app_version,promoter_id,ctime,utime,is_delete)\n" +
                " values \n" +
                "(@order_id,\n" +
                "@uid,\n" +
                "'000',\n" +
                "@order_price,\n" +
                "@pay_price,\n" +
                "@order_status,\n" +
                "'3',\n" +
                "@delivery_status,\n" +
                "@create_date,\n" +
                "@utime,\n" +
                "@chl_id,\n" +
                "'3',\n" +
                "'620',\n" +
                "'601',\n" +
                "'tmm_ceshi',\n" +
                "'30',\n" +
                "@choose_pay_way,\n" +
                "null,\n" +
                "@outter_game_id,\n" +
                "@chl_id,\n" +
                "null,\n" +
                "null,\n" +
                "null,\n" +
                "null,\n" +
                "null,\n" +
                "@utime,\n" +
                "@utime,\n" +
                "'1'\n" +
                ");";
        List listUser= MySqlHelper.getUcenterHelper().executeQueryList(game_binding_sql);
        // System.out.println(game_binding_sql);

        for(Object oUser :listUser) {
            Map mUser = (Map) oUser;
            //每个用户+游戏循环多少次
            int i = RandomUtil.getRandomNumber(0, 8);
            while (i > 0) {
                int order_price =  RandomUtil.getRandomNumber(6, 10);
                int pay_price =  RandomUtil.getRandomNumber(4, order_price);
                int coupon_price = order_price - pay_price;
                int choose_pay_way = RandomUtil.getRandomNumber(1, 5);
                String uid = mUser.get("uid").toString();
                String outter_game_id = mUser.get("outter_game_id").toString();
                String sql_indexOrder = index_order_sql.replace("${uid}", uid);
                sql_indexOrder = sql_indexOrder.replace("${outter_game_id}", outter_game_id);
                sql_indexOrder = sql_indexOrder.replace("${order_price}", String.valueOf(order_price));
                sql_indexOrder = sql_indexOrder.replace("${pay_price}", String.valueOf(pay_price));
                sql_indexOrder = sql_indexOrder.replace("${choose_pay_way}", String.valueOf(choose_pay_way));
                MySqlHelper.getTradedbHelper().executeSqlBatch(sql_indexOrder);
                System.out.println(sql_indexOrder);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (coupon_price > 0) {
                    //如果为3 生成多张代金券
                    if(coupon_price >= 3){
                        while (coupon_price> 0){
                            AddCoupon(1);
                            coupon_price --;
                        }
                    }else {
                        AddCoupon(coupon_price);
                    }
                }
                i--;
            }

        }
    }
    private static void AddCoupon(int coupon_price){
        String coupon_sql ="SET @coupon_id = (SELECT MAX(coupon_id)+1 from csp_coupon);\n" +
                "set @coupon_value="+coupon_price+"*10;\n" +
                "set @record_id = (SELECT MAX(record_id)+1 from csp_coupon_use_record);\n" +
                "\n" +
                "INSERT INTO  `csp_coupon` (`coupon_id`, `biz_type`, `account_type`, `account_id`, `game_id`, `os_type`, `expire_time`, `value`, `valid_days`, `balance`, `uid`, `coupon_status`, `remark`, `ctime`, `utime`, `creator`) \n" +
                "VALUES (@coupon_id, ${biz_type}, '${account_type}', '${account_id}', '${game_id}', '${os_type}', '888',@coupon_value, '7', '0', @uid, '2', NULL, '1515644000', '1515644000', '-1');\n" +
                "\n" +
                "INSERT INTO `csp_coupon_use_record` (`record_id`, `coupon_id`, `order_id`, `amount`, `uid`, `ctime`, `utime`) \n" +
                "VALUES (@record_id, @coupon_id, @order_id, @coupon_value, @uid,@utime,@utime);";
        int biz = RandomUtil.getRandomNumber(1, 2);
        String sql_coupon = coupon_sql.replace("${biz_type}", String.valueOf(biz));
        int account_type = biz==1?2:1;
        sql_coupon=sql_coupon.replace("${account_type}",String.valueOf(account_type));
        if (biz ==2){
            //随机取员工uid
            String account_id =MySqlHelper.getGamemallHelper().executeStr("SELECT uid from t_mer ORDER BY RAND() LIMIT 1;");
            sql_coupon=sql_coupon.replace("${account_id}",String.valueOf(account_id));
        }
        else {
            sql_coupon=sql_coupon.replace("${account_id}","999");
        }
        Map m_game = MySqlHelper.getGamemallHelper().executeMap("select game_id,os_type from t_game ORDER BY RAND() LIMIT 1;");
        sql_coupon=sql_coupon.replace("${game_id}",String.valueOf(m_game.get("game_id")));
        sql_coupon=sql_coupon.replace("${os_type}",String.valueOf(m_game.get("os_type")));

        MySqlHelper.getTradedbHelper().executeSqlBatch(sql_coupon);
        System.out.println(sql_coupon);

    }

    public static  void  statis(){
        String init_sql="set @statis_date='"+statis_date+"';";
         String order_sql="select  a.*,(CASE WHEN ISNULL(grdjq) THEN pay_price ELSE (pay_price+grdjq) END)    as total from (\n" +
                 "SELECT order_id,buyer_uid,order_price,pay_price,sdk_game_id, (\n" +
                 " CASE WHEN (pay_price< order_price  ) THEN \n" +
                 "(SELECT SUM(b.amount)/10 from csp_coupon_use_record b INNER JOIN csp_coupon c on b.coupon_id = c.coupon_id where b.order_id = a.order_id and c.biz_type =2 ) ELSE 0 END\n" +
                 ") as grdjq  from index_order_info a where create_date= DATE_FORMAT(@statis_date,'%Y%m%d') and order_status =4 and game_id=3 ORDER BY sdk_game_id  ) a\n" +
                 ";";
         String game_bind ="select chl_id from user_game_binding  ";
         String t_mer ="select a.uid,a.channel_id,b.leader_uid from t_mer a  LEFT JOIN t_mer_group b on a.uid = b.member_uid ";
         String t_leader_fc="select * from t_mer_revenue_ration ";
        MySqlHelper.getTradedbHelper().execute(init_sql);
        List game_bind_list=MySqlHelper.getUcenterHelper().executeQueryList(game_bind);
        List t_mer_list = MySqlHelper.getGamemallHelper().executeQueryList(t_mer);
        List order_list = MySqlHelper.getTradedbHelper().executeQueryList(order_sql);
        List<Map<String,String>> statisList = new ArrayList<Map<String,String>>();
        for (Object o :order_list){
             Map<String,String > map =(Map<String,String > )o;
             String str_uid =String.valueOf(map.get("buyer_uid"));
             String str_outter=map.get("sdk_game_id").toString();
             String lins_sql=game_bind+"where uid="+str_uid+"  and outter_game_id ='"+str_outter+"'";
            String chi_id = MySqlHelper.getUcenterHelper().executeStr(lins_sql);
            map.put("chl_id",chi_id);
            Map<String,String> m2 =MySqlHelper.getGamemallHelper().executeMap(t_mer+"where a.channel_id='"+chi_id+"'");
            if(m2!=null) {
                map.put("member_uid", m2.get("uid"));
                map.put("leader_uid", m2.get("leader_uid"));

                String game_fc = MySqlHelper.getGamemallHelper().executeStr("select revenue_ration from t_game where outter_game_id='" + map.get("sdk_game_id") + "'");
                map.put("game_fc",game_fc);
                String zg_fc = MySqlHelper.getGamemallHelper().executeStr("select revenue_ration from t_mer_revenue_ration where outter_game_id ='" + map.get("sdk_game_id") + "' and leader_uid='" +String.valueOf(m2.get("leader_uid"))  + "';");
                map.put("zg_fc", zg_fc);
                statisList.add(map);
            }
        }
        statis_total(statisList);
        //System.out.println(JSON.toJSON(statisList) );
    }
    private static String statis_date="2018-01-09";
    private static void  statis_total(List<Map<String,String>> statisList){
        List <Map<String,String>> listNew = new ArrayList<Map<String,String>>();
        for (Map<String,String> m :statisList){
            Map<String,String> old =getmap(listNew,String.valueOf(m.get("uid")),m.get("sdk_game_id"));
            if (old ==null){
                old = new HashMap<String,String>();
                old.put("member_uid",String.valueOf(m.get("member_uid")));
                old.put("leader_uid",String.valueOf(m.get("leader_uid")));
                old.put("sdk_game_id",m.get("sdk_game_id"));
                old.put("game_fc",m.get("game_fc"));
                old.put("zg_fc",m.get("zg_fc"));
                old.put("total",m.get("total"));
                old.put("grdjq",(m.get("grdjq")==null) ?"0":String.valueOf(m.get("grdjq")) );
                listNew.add(old);
            }else
            {
                //当前行的total字段
                int lineTotal  =Integer.parseInt( m.get("total"));
                //汇总list对应的total字段
                int sumTotal = Integer.parseInt(old.get("total")) ;
                sumTotal =sumTotal+lineTotal;
                old.put("total",String.valueOf(sumTotal) );
                old.put("grdjq",String.valueOf(Integer.parseInt(old.get("grdjq"))+Integer.parseInt(m.get("grdjq"))));
            }
        }


        String strSQL="INSERT INTO `gamemall`.`tmm_statis_js` (statis_date,`leader_uid`, `game_fc`, `member_uid`, `total`, `sdk_game_id`, `zg_fc`,grdjq) \n" +
                "VALUES (@statis_date,'${leader_uid}', ${game_fc}, '${member_uid}', ${total}, '${sdk_game_id}', ${zg_fc},${grdjq});";
        MySqlHelper.getGamemallHelper().execute("set @statis_date='"+statis_date+"';");
        MySqlHelper.getGamemallHelper().execute("delete from tmm_statis_js where statis_date=@statis_date;");
        for (Map<String,String> m :listNew){
            String s = strSQL.replace("${leader_uid}",String.valueOf(m.get("leader_uid")).equals("")?"0":String.valueOf(m.get("leader_uid")) );
            s=s.replace("${game_fc}",String.valueOf(m.get("game_fc")).equals("")?"0":String.valueOf(m.get("game_fc")));
            s=s.replace("${member_uid}",String.valueOf(m.get("member_uid")).equals("")?"0":String.valueOf(m.get("member_uid")));
            s=s.replace("${total}",String.valueOf(m.get("total")).equals("")?"0":String.valueOf(m.get("total")));
            s=s.replace("${sdk_game_id}",String.valueOf(m.get("sdk_game_id")).equals("")?"0":String.valueOf(m.get("sdk_game_id")));
            s=s.replace("${zg_fc}",String.valueOf(m.get("zg_fc")).equals("")?"0":String.valueOf(m.get("zg_fc")));
            s=s.replace("${grdjq}",String.valueOf(m.get("grdjq")).equals("")?"0":String.valueOf(m.get("grdjq")));

            MySqlHelper.getGamemallHelper().execute(s);
            System.out.println(s);


        }
        System.out.println(JSON.toJSON(listNew));
    }


    private static  Map<String,String > getmap(List<Map<String,String>> list,String uid,String outter_game_id){
         Map<String,String > map = null;

        for(Map<String,String > mp  : list){
            if ((mp.get("uid")!=null&&!mp.get("uid").equals(uid) )
                    && (mp.get("uid")!=null&&!mp.get("sdk_game_id").equals(outter_game_id))){
                return  mp;
            }
        }
        return  map;
    }


}
