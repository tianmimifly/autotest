package com.milan.entity;

public class ExcelCaseEnd {
    //返回值断言结果
    private String caseAssert;
    //db断言结果
    private String dbAssert;
    //返回结果
    private String returnData;
    //结束要执行的sql
    private String end_sql;
    //endsql的执行结果
    private String end_sql_excute;
    public String getEnd_sql() {
        return end_sql;
    }

    public void setEnd_sql(String end_sql) {
        this.end_sql = end_sql;
    }

    public String getEnd_sql_excute() {
        return end_sql_excute;
    }

    public void setEnd_sql_excute(String end_sql_excute) {
        this.end_sql_excute = end_sql_excute;
    }

    public String getCaseAssert() {
        return caseAssert;
    }

    public void setCaseAssert(String caseAssert) {
        this.caseAssert = caseAssert;
    }

    public String getDbAssert() {
        return dbAssert;
    }

    public void setDbAssert(String dbAssert) {
        this.dbAssert = dbAssert;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }
}
