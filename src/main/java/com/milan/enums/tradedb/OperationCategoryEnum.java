package com.milan.enums.tradedb;

/**
 * 操作子类型
 */
public enum OperationCategoryEnum {

    ACTIVITY_AMOUNT(101, "活动注资"),
    ACTIVITY_ONLINE(102, "活动上线"),
    ACTIVITY_OFFLINE(103, "活动下线"),
    CONFIG_ONLINE(201, "配置上架"),
    CONFIG_OFFLINE(201, "配置下架");

    private Integer code;
    private String message;

    OperationCategoryEnum(Integer code, String message) {
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
