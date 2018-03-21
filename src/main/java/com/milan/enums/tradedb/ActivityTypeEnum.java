package com.milan.enums.tradedb;

/**
 * 活动类型
 */
public enum ActivityTypeEnum {
    PUBLISH_AUTO(1, "自动发放代金券"),
    PUBLISH_HAND(2, "手动发放代金券");

    private Integer code;
    private String message;

    ActivityTypeEnum(Integer code, String message) {
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
