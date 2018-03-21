package com.milan.enums.tradedb;

/**
 * 操作大类型
 */
public enum OperationTypeEnum {

    ACTIVITY_RECORD(1, "活动"),
    CONFIG_RECORD(2, "代金券配置");

    private Integer code;
    private String message;

    OperationTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
