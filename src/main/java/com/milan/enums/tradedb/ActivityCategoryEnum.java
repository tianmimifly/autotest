package com.milan.enums.tradedb;

/**
 * 活动类别
 */
public enum ActivityCategoryEnum {
    PRE_REGEDIT(1, "预注册-单推"),
    MENG_RECOMMAND(2, "喵盟推荐"),
    OPEN_SERVER(3, "开服游戏");

    private Integer code;
    private String message;

    ActivityCategoryEnum(Integer code, String message) {
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
