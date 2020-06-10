package com.sodacar.starter.sms.weimi;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class WeimiSmsSender implements ISmsSender {


    private SmsProperties smsProperties;

    public WeimiSmsSender(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }

    @Override
    public String send(String mobile, String content) {
        if (StringUtils.isEmpty(mobile)) {
            log.info("mobile is empty!");
            return null;
        }
        if (StringUtils.isEmpty(content)) {
            log.info("content is empty!");
            return null;
        }
        return doSend(buildSmsParams(mobile, content));
    }

    private Map<String, String> buildSmsParams(String mobile, String content) {
        Map<String, String> params = new HashMap<>();
        params.put("uid", smsProperties.getUid());
        params.put("pas", smsProperties.getPas());
        params.put("type", "json");
        params.put("mob", mobile);
        params.put("con", content);

        return params;
    }

    @Override
    public String send(String cid, String mobile, String[] pArray) {
        if (StringUtils.isEmpty(cid)) {
            log.info("cid is empty!");
            return null;
        }
        if (StringUtils.isEmpty(mobile)) {
            log.info("mobile is empty!");
            return null;
        }
        return doSend(buildSmsParams(cid, mobile, pArray));
    }

    private Map<String, String> buildSmsParams(String cid, String mobile, String[] pArray) {
        Map<String, String> params = new HashMap<>();
        params.put("uid", smsProperties.getUid());
        params.put("pas", smsProperties.getPas());
        // 必须设置模板cid
        params.put("cid", cid);
        params.put("type", "json");
        params.put("mob", mobile);
        if (null != pArray && pArray.length > 0) {
            for (int i = 0; i < pArray.length; i++) {
                params.put("p" + (i + 1), pArray[i]);
            }
        }
        return params;
    }

    private String doSend(Map<String, String> params) {
        try {
            WeimiResponse weimiResponse = JsonUtils.toObject(
                    HttpClientHelper.convertStreamToString(
                            HttpClientHelper.post(smsProperties.getUri(), params), "UTF-8")
                    , WeimiResponse.class).get();
            log.info("weimi sms send:uri:{},response:{}", smsProperties.getUri(), weimiResponse);
            return WeimiErrorEnum.valueOf(weimiResponse.getCode()).getMessage();
        } catch (Exception e) {
            String errorMsg = "send message error!params is " +
                    JsonUtils.toJson(params);
            log.error(errorMsg, e);
        }
        return null;
    }
}
