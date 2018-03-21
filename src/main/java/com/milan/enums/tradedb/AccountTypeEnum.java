package com.milan.enums.tradedb;

/**
 * 账户类型
 */
public enum AccountTypeEnum {

    PERSON(1, "个人账户"),
    PLATFORM(2, "平台账户");

    private Integer code;
    private String message;

    AccountTypeEnum(Integer code, String message) {
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
