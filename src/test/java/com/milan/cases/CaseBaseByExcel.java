package com.milan.cases;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.milan.entity.ExcelCaseOne;
import com.milan.net.MySqlHelper;
import com.milan.utils.*;
import org.testng.annotations.*;
public class CaseBaseByExcel {
    protected String caseExcelPath =System.getProperty("user.dir")+"\\exceltmp\\" ; // System.getProperty("user.dir")+"\\exceltmp\\coupon\\${name}.xlsx";
    private ExcelHelper _excelHelper=null;
    protected ExcelCaseUtil excelCaseUtil;
    protected CaseBaseByExcel(){}
    @BeforeClass
    public void CaseBaseInit(){
            _excelHelper = new ExcelHelper(caseExcelPath);
            if (_excelHelper!=null){
                excelCaseUtil = new ExcelCaseUtil(_excelHelper.readXlsx());
                excelCaseUtil.setExcelCaseConfig(_excelHelper.getExCaseInit());
            }
    }


    @DataProvider(name="dataInfo")
    protected Object[][]dataInfo1(){
        Object[][] myObj = null;
        if (excelCaseUtil !=null){
            myObj = excelCaseUtil.getExcuteProvider();
        }
        return myObj;
    }
    @AfterClass
    public void WrteExcel(){
        if (_excelHelper!=null){
            _excelHelper.writeExcelResult();
        }
    }
    protected void updateExcel(ExcelCaseOne c){
        int index =Integer.parseInt(c.getExcelCaseDesc().getRowIndex()) ;//  Integer.parseInt(c.getCaseDesc().get("rowIndex"));
        //String assertResult =c.getExcelCaseEnd().getReturnData();
        _excelHelper.updateExcuteResult(c);
    }
    protected void excuteEndSql(ExcelCaseOne c){
        //执行end sql
        String end_sql=c.getExcelCaseEnd().getEnd_sql();
        if (end_sql==null || end_sql.equals("")){
            end_sql =excelCaseUtil.getExcelCaseConfig().getEnd_sql();
        }
        if (!end_sql.equals("n")){
            String str =excute_Sql(end_sql);
            c.getExcelCaseEnd().setEnd_sql_excute(str);
        }
    }
    protected  void excuteInit(ExcelCaseOne c){
        //打印执行测试用例
        //LogUtil.begunCaseByExcel(c.getExcelCaseDesc().getCaseDesc());
        LogUtil.logInfo("----------用例执行--------------");
        String init_sql=c.getExcelCasePreset().getInit_sql1();
        String init_sql2 =c.getExcelCasePreset().getInit_sql2();
        if (init_sql==null || init_sql.equals("")){
            init_sql = excelCaseUtil.getExcelCaseConfig().getInit_sql();
        }
        if (!init_sql.equals("n")){
            String str_excute = excute_Sql(init_sql);
            c.getExcelCasePreset().setInit_sql_excute(str_excute);
        }
        excute_Sql(init_sql2);
    }
    private String excute_Sql(Object objSql){
        String json ="";
        String strSql =objSql==null?"":  objSql.toString();
        if (!strSql.equals("")){
            List l=  MySqlHelper.getTradedbHelper().executeSqlBatch(strSql);
            if(l.size()>0){
                json =JSON.toJSONString(l);
                LogUtil.logInfo("excute_sql:",json);
            }
        }
        return  json;
    }
    protected static final String host="http://testtrade-nw.youximao.cn";
    //protected static final String host="http://trade.dm.com";
    protected static Map<String,String> myRequest(String url,String method, Map<String,String> params){
        LogUtil.logInfo("--请求--"+url);
        LogUtil.logInfo(params.toString());
        String resultJson= "";
        if (method.equals("get")){
            resultJson= HttpUtil.sendGet(url,params).getContent();
        }else if (method.equals("post"))
        {
            try {
                resultJson= HttpUtil.sendPost(url,params).getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LogUtil.logInfo("--返回结果--");
        LogUtil.logInfo(resultJson);
        return JSON.parseObject(resultJson,Map.class);
    }
}
