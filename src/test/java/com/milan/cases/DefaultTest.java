package com.milan.cases;
import com.alibaba.fastjson.JSON;
import com.milan.service.ucenter.user_base_info;
import com.milan.entity.ExcelCaseOne;
import com.milan.utils.Assertion;
import com.milan.utils.LogUtil;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
//领取活动所有的代金券. -- 开服活动
@Listeners({com.milan.utils.AssertionListener.class})
public class DefaultTest extends CaseBaseByExcel {
    String strPath = "coupon\\receiveByActivityId.xlsx";

    public DefaultTest() {
        caseExcelPath = caseExcelPath + strPath;
    }
    //    public void  Test_Before(ExcelCaseInfo c){
//        excuteInit(c);
//    }
    @Test(dataProvider = "dataInfo")
    public void Test_ByExcel(ExcelCaseOne c) {
        System.out.println(c.getCaseParam());
        //执行预置条件
        excuteInit(c);
        String uid = user_base_info.getUids(1).get(0);
        c.getCaseParam().put("uid", uid);
        String url = host + excelCaseUtil.getExcelCaseConfig().getUrl();
        Map mresult = new HashMap();
        //myRequest(url,excelCaseUtil.getExcelCaseConfig().getMethod(), c.getCaseParam());
//        //执行测试用例
        boolean b = false;
        //断言
        if (c.getExcelCaseDesc().getCaseExpect().indexOf("n_") ==0) {
            b =Assertion.verifyNotEquals(mresult.get("code"), c.getExcelCaseDesc().getCaseExpect().replace("n_", ""), "验证code");
        } else {
            b =Assertion.verifyEquals(mresult.get("code"), c.getExcelCaseDesc().getCaseExpect(), "验证code");
        }
        c.getExcelCaseEnd().setCaseAssert( b ? "T" : "F");
        c.getExcelCaseEnd().setReturnData(JSON.toJSONString(mresult));
//        //输出结果
        excuteEndSql(c);
        updateExcel(c);
        LogUtil.logInfo("-------【end】------------\n");
    }
}
