package com.sodacar.starter.sms;

import com.sodacar.starter.sms.weimi.SmsProperties;
import com.sodacar.starter.sms.weimi.WeimiSmsSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

// 配置注解  ,标记该类是个配文类
@Configuration
// 开启指定类的配置，既是接受配置文件中的参数的类， 多个时我们可以这么写value={Properties1.class,Properteis2.class....}
@EnableConfigurationProperties(SmsProperties.class)
// 当这个类（WeimiSmsSender）在classPath下，并且容器 中没有相同的，就自动配置
@ConditionalOnClass(WeimiSmsSender.class)
public class SmsAutoConfiguration {

    @Resource
    private SmsProperties smsProperties;


    @Bean
    @ConditionalOnMissingBean(WeimiSmsSender.class)// 当容器中没有指定Bean的情况下，自动配置WeimiSmsSender类
    public WeimiSmsSender weimiSmsSender() {
        return new WeimiSmsSender(smsProperties);
    }
}
