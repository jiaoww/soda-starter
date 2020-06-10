package com.sodacar.starter.sms.weimi;

/**
 * sms发送
 */
public interface ISmsSender {

    /**
     * @param mobile  电话号码
     * @param content 发送内容
     * @return 发送结果
     */
    String send(String mobile, String content);

    /**
     * 发送sms
     *
     * @param cid    短信模版id
     * @param mobile 手机号
     * @param pArray 参数数组
     * @return
     */
    String send(String cid, String mobile, String[] pArray);
}
