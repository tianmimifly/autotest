package com.milan.enums.tradedb;

/**
 * 活动状态
 */
public enum ActivityStatus {

    TOBE_ONLINE(1, "待上线"),
    ONLINE(2, "已上线"),
    OFFLINE(3, "已下线");

    private Integer code;
    private String message;

    ActivityStatus(Integer code, String message) {
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
