package com.milan.enums.tradedb;

/**
 * 资金业务类型
 */
public enum CapitalBizTypeEnum {

    INJECT_AMOUNT(1, "注资"),
    PUBLISH_AUTO(2, "自动发放代金券"),
    PUBLISH_HAND(3, "手动发放代金券"),
    RECYCLE_COUPON(4, "回收代金券");

    private Integer code;
    private String message;

    CapitalBizTypeEnum(Integer code, String message) {
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
