package com.milan.enums.tradedb;

/**
 *  代金券配置状态
 */
public enum CouponConfigStatus {

    CREATE(1, "已创建"),
    ONLINE(2, "已上线"),
    OFFLINE(3, "已下线");

    private Integer code;
    private String message;

    CouponConfigStatus(Integer code, String message) {
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
