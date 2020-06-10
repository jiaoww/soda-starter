package com.sodacar.starter.sms.weimi;


public enum WeimiErrorEnum {

    ZERO(0, "短信提交成功"),
    NEGATIVE_ONE(-1, "参数不正确或短信内容签名不规范"),
    NEGATIVE_TWO(-2, "非法账号"),
    NEGATIVE_THREE(-3, "IP鉴权失败"),
    NEGATIVE_FOUR(-4, "账号余额不足"),
    NEGATIVE_FIVE(-5, "下发失败"),
    NEGATIVE_SIX(-6, "短信内容含有非法关键字"),
    NEGATIVE_SEVEN(-7, "同一个号码、同一段短信内容，在同一小时内重复下发"),
    NEGATIVE_NINE(-9, "短信内容过长"),
    NEGATIVE_TEN(-10, "定时计划时间不正确"),
    NEGATIVE_ELEVEN(-11, "CID不正确"),
    NEGATIVE_THIRTEEN(-13, "一次性提交手机号码过多"),
    NEGATIVE_FIFTEEN(-15, "定时计划时间不正确"),
    NEGATIVE_SIXTEEN(-16, "定时计划时间不正确"),
    ;

    private int code;
    private String message;

    WeimiErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static WeimiErrorEnum valueOf(int code) {

        switch (code) {
            case -16:
                return NEGATIVE_SIXTEEN;
            case -15:
                return NEGATIVE_FIFTEEN;
            case -13:
                return NEGATIVE_THIRTEEN;
            case -11:
                return NEGATIVE_ELEVEN;
            case -10:
                return NEGATIVE_TEN;
            case -9:
                return NEGATIVE_NINE;
            case -7:
                return NEGATIVE_SEVEN;
            case -6:
                return NEGATIVE_SIX;
            case -5:
                return NEGATIVE_FIVE;
            case -4:
                return NEGATIVE_FOUR;
            case -3:
                return NEGATIVE_THREE;
            case -2:
                return NEGATIVE_TWO;
            case -1:
                return NEGATIVE_ONE;
            case 0:
            default:
                return ZERO;
        }
    }
}
