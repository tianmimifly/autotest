package com.milan.entity;
import java.util.Map;
//excel一条测试用例
public class ExcelCaseOne {
    //请求参数
    private Map<String,String> caseParam;
    //用例说明
    private ExcelCaseDesc excelCaseDesc;
    //预置条件
    private ExcelCasePreset excelCasePreset;
    //执行结果
    private ExcelCaseEnd excelCaseEnd;

    public Map<String, String> getCaseParam() {
        return caseParam;
    }
    public void setCaseParam(Map<String, String> caseParam) {
        this.caseParam = caseParam;
    }
    public ExcelCaseDesc getExcelCaseDesc() {
        return excelCaseDesc;
    }
    public void setExcelCaseDesc(ExcelCaseDesc excelCaseDesc) {
        this.excelCaseDesc = excelCaseDesc;
    }
    public ExcelCasePreset getExcelCasePreset() {
        return excelCasePreset;
    }
    public void setExcelCasePreset(ExcelCasePreset excelCasePreset) {
        this.excelCasePreset = excelCasePreset;
    }
    public ExcelCaseEnd getExcelCaseEnd() {
        return excelCaseEnd;
    }
    public void setExcelCaseEnd(ExcelCaseEnd excelCaseEnd) {
        this.excelCaseEnd = excelCaseEnd;
    }
}
