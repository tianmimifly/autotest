package com.milan;
import com.milan.entity.ExcelCaseEnd;
import com.milan.utils.ClassUtil;
import com.milan.utils.PropertiesUtil;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {

//        Class<ExcelCaseEnd>  clz=ExcelCaseEnd.class;
//        Field[] af = clz.getDeclaredFields();
//        for (Field f :af){
//            System.out.println(f.getName());
//        }


        ExcelCaseEnd a = new ExcelCaseEnd();
       // a.getCaseAssert();
        //a.getEnd_sql()
        try {
            ClassUtil.setValue(a,"caseAssert","123");
            ClassUtil.setValue(a,"end_sql1","222");
            System.out.println(a.getCaseAssert());
            System.out.println(a.getEnd_sql());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


//        System.out.println("---getAlistatiDB------------");
//        System.out.println(PropertiesUtil.getAlistatiDB());
//        System.out.println("---getGamemallDB------------");
//        System.out.println(PropertiesUtil.getGamemallDB());
//        System.out.println("---getTradedb1DB------------");
//        System.out.println(PropertiesUtil.getTradedb1DB());
//        System.out.println("---getUcenterDB------------");
//        System.out.println(PropertiesUtil.getUcenterDB());
//        System.out.println("---getMyDB------------");
//        System.out.println(PropertiesUtil.getMyDB());
//        System.out.println(PropertiesUtil.getValue());

//        Properties properties = new Properties();
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("config/application.properties"));
//            properties.load(bufferedReader);
//              // 获取key对应的value值
//            System.out.println(properties.getProperty("gamemall.datasource.url"));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Map<String,String> map =new HashMap<String, String>();
//        System.out.println("000000");
//        System.out.println(map.get("abc"));
       // System.out.println(user_base_info.getUids(5).toString()); ;
        //int balance =csp_activity.getBalanceById("1514363097942899");
        //System.out.println(String.valueOf(balance) );
        //List l = csp_coupon_bll.getCanUse("11");
       // System.out.println(csp_activity_capital_flow.getRowByActivityID("1514363097942899"));
//        String strJSON ="{\n" +
//                "\"code\": \"2000\",\n" +
//                "\"message\": \"hello\",\n" +
//                "\"data\": true\n" +
//                "}";
//        Map<String,String> map = new HashMap<String, String>() ;
//        map=  JSON.parseObject(strJSON,map.getClass());
//        System.out.println(map.get("code"));
      //  test02();
        //System.out.println(getMatcher("from +(\\w*)","select * from   t_mer where a=b")); ;
       // System.out.println(getMatcher("select +(.*)","select @abc")); ;
       // Random rand = new Random();
       // System.out.println(rand.nextInt(1000));
    }

    public static void  test02(){
        String str="select * from user_base_info limit 1";
       // System.out.println(MySqlHelper.getUcenterHelper().executeMap(str)); ;

    }
    //打印执行2条sql语句的结果
    public static void test1(){
        String str="delete from csp_activity where activity_id='1000111111';set @activity_id='1000111111';set @balance =100;\n" +
                "INSERT INTO `tradedb1`.`csp_activity` (`activity_id`, `activity_name`, `activity_type`, `activity_status`, `begin_time`, `end_time`, `balance`, `creator`, `remark`, `ctime`, `utime`) VALUES (@activity_id, 'tmm_itest', '1', '2',UNIX_TIMESTAMP(date_format(DATE_SUB(NOW(),INTERVAL +1 DAY), '%Y%m%d')),UNIX_TIMESTAMP(date_format(DATE_SUB(NOW(),INTERVAL -10 DAY), '%Y%m%d')) , @balance, '12345', NULL, '1515045790', '1515144511');select * from csp_activity where activity_id='1000111111'" ;
        str+="";
       // str+="select * from csp_coupon where uid=@uid;";
        String str2 ="set @begin= UNIX_TIMESTAMP(str_to_date(NOW(), '%Y-%m-%d'));select @begin";
     // List l =  MySqlHelper.getTradedbHelper().executeSqlBatch(str);
     // System.out.println(l);

    }
    public static String getMatcher(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }
}
