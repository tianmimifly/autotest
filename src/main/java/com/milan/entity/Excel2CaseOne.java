package com.milan.entity;

///excel2
public class Excel2CaseOne {
    private String isExcute;
    private String url;
    private String method;
    private String requestHead;
    private String requestParam;

    public String getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    private String rowIndex;

    public String getIsExcute() {
        return isExcute;
    }

    public void setIsExcute(String isExcute) {
        this.isExcute = isExcute;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(String requestHead) {
        this.requestHead = requestHead;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAssertResult() {
        return assertResult;
    }

    public void setAssertResult(String assertResult) {
        this.assertResult = assertResult;
    }



    private String response;
    private String desc;
    private String assertResult;

    public String getExpectResult() {
        return expectResult;
    }

    public void setExpectResult(String expectResult) {
        this.expectResult = expectResult;
    }

    private String expectResult;


}
