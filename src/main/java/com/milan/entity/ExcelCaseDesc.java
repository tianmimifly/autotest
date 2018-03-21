package com.milan.entity;


public class ExcelCaseDesc {


    public String getRowIndex() {
        return rowIndex;
    }
    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }
    //excel索引 更新用
    private String rowIndex;
    //用例编号
    private String caseID;
    //用例说明
    private String caseDesc;
    //是否执行 为y表示执行
    private String isexcute;
    //期望结果
    private String caseExpect;
    //db期望结果
    private String dbExpect;

    public String getCaseID() {
        return caseID;
    }
    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc;
    }

    public String getIsexcute() {
        return isexcute;
    }

    public void setIsexcute(String isexcute) {
        this.isexcute = isexcute;
    }

    public String getCaseExpect() {
        return caseExpect;
    }

    public void setCaseExpect(String caseExpect) {
        this.caseExpect = caseExpect;
    }

    public String getDbExpect() {
        return dbExpect;
    }

    public void setDbExpect(String dbExpect) {
        this.dbExpect = dbExpect;
    }


}
