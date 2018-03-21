package com.milan.entity;

public class ExcelCaseConfig {
    //请求地址
    private String url;
    //请求方法
    private String method;
    //请求头
    private String request_header;
    //初始化sql
    private String init_sql;
    //结束执行的sql
    private String end_sql;

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

    public String getRequest_header() {
        return request_header;
    }

    public void setRequest_header(String request_header) {
        this.request_header = request_header;
    }

    public String getInit_sql() {
        return init_sql;
    }

    public void setInit_sql(String init_sql) {
        this.init_sql = init_sql;
    }

    public String getEnd_sql() {
        return end_sql;
    }

    public void setEnd_sql(String end_sql) {
        this.end_sql = end_sql;
    }
}
