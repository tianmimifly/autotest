package com.milan.enums.tradedb;

/**
 * 【账户状态枚举值】
 *
 * @author shenjy 2017/11/11
 */
public enum AccountStatus {

    NORMAL(1, "正常"),
    FROZEN(2, "冻结");

    private Integer code;
    private String message;

    AccountStatus(Integer code, String message) {
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
