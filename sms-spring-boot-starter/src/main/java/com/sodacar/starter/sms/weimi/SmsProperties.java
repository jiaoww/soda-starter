package com.sodacar.starter.sms.weimi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "sms.weimi")
public class SmsProperties {
    /**
     * 微米账号的接口UID
     */
    private String uid = "ttMMmK05ybrt";

    /**
     * 微米账号的接口密码
     */
    private String pas = "4z2faft7";

    /**
     * 接口api
     */
    private String uri = "http://api.weimi.cc/2/sms/send.html";
}
