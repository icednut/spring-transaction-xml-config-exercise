package io.icednut.exercise.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-20
 */
@Configuration
@EnableAspectJAutoProxy
public class DatabaseTransactionConfig {

    // 방법1. 특정 서비스 빈에서만 동작하는 Transaction Attribute를 정의한 TransactionInterceptor를 사용한다. (TransactionProxyFactoryBean을 이용)
    //    @Bean
    //    @Primary
    //    public TransactionProxyFactoryBean transactionProxyFactoryBean(TodoService todoService, PlatformTransactionManager transactionManager) {
    //        TransactionProxyFactoryBean transactionProxyFactoryBean = new TransactionProxyFactoryBean();
    //        Properties properties = new Properties();
    //
    //        properties.put("get*", "PROPAGATION_SUPPORTS,readOnly");
    //        properties.put("*", "PROPAGATION_REQUIRED");
    //        transactionProxyFactoryBean.setTransactionManager(transactionManager);
    //        transactionProxyFactoryBean.setTransactionAttributes(properties);
    //        transactionProxyFactoryBean.setTarget(todoService);
    //        return transactionProxyFactoryBean;
    //    }

    // 방법 2. AspectJ Auto Proxy를 써서 Transaction Advice를 적용해보자.
}
