package io.icednut.exercise.infra.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author wangeun.lee@sk.com
 * @since 2017-02-20
 */
@Configuration
@EntityScan({"io.icednut.exercise.infra.entity"})
@EnableJpaRepositories({"io.icednut.exercise.infra.repository"})
//@EnableAspectJAutoProxy
public class DatabaseTransactionConfig {

    // 방법1. 특정 서비스 빈에서만 동작하는 Transaction Attribute를 정의한 TransactionInterceptor를 사용한다. (TransactionProxyFactoryBean을 이용)
    //    @Bean
    //    @Primary
    //    public TransactionProxyFactoryBean transactionProxyFactoryBean(TodoService todoService, PlatformTransactionManager transactionManager) {
    //        TransactionProxyFactoryBean transactionProxyFactoryBean = new TransactionProxyFactoryBean();
    //        Properties properties = new Properties();
    //
    //        properties.put("get*", "PROPAGATION_SUPPORTS,readOnlyTx");
    //        properties.put("*", "PROPAGATION_REQUIRED");
    //        transactionProxyFactoryBean.setTransactionManager(transactionManager);
    //        transactionProxyFactoryBean.setTransactionAttributes(properties);
    //        transactionProxyFactoryBean.setTarget(todoService);
    //        return transactionProxyFactoryBean;
    //    }

    // 방법 2. AspectJ Auto Proxy를 써서 Transaction Advice를 적용해보자.
    //    @Bean
    //    public AspectJExpressionPointcut pointcut() {
    //        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    //        pointcut.setExpression("execution(* io.icednut.exercise.api.support..*(..))");
    //        return pointcut;
    //    }
    //
    //    @Bean
    //    public DefaultBeanFactoryPointcutAdvisor advisor(Pointcut pointcut, Advice txAdvice) {
    //        DefaultBeanFactoryPointcutAdvisor advisor = new DefaultBeanFactoryPointcutAdvisor();
    //
    //        advisor.setPointcut(pointcut);
    //        advisor.setAdvice(txAdvice);
    //        return advisor;
    //    }
    //
    //    @Bean
    //    public TransactionInterceptor txAdvice(PlatformTransactionManager transactionManager, BeanFactory beanFactory) {
    //        TransactionInterceptor txAdvice = new TransactionInterceptor();
    //        NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();
    //        //        ManagedMap<TypedStringValue, RuleBasedTransactionAttribute> nameMap = new ManagedMap<>();
    //        Map<String, TransactionAttribute> nameMap = new HashMap<>();
    //
    //        nameMap.put("*", allTx());
    //        nameMap.put("get*", readOnlyTx());
    //        transactionAttributeSource.setNameMap(nameMap);
    //
    //        txAdvice.setTransactionManager(transactionManager);
    //        txAdvice.setTransactionAttributeSource(transactionAttributeSource);
    //        txAdvice.setBeanFactory(beanFactory);
    //        return txAdvice;
    //    }
    //
    //    private TransactionAttribute allTx() {
    //        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
    //        List<RollbackRuleAttribute> rollbackRules = new ArrayList<>();
    //
    //        transactionAttribute.setRollbackRules(rollbackRules);
    //        transactionAttribute.setPropagationBehaviorName(RuleBasedTransactionAttribute.PREFIX_PROPAGATION + "REQUIRED");
    //        transactionAttribute.setIsolationLevelName(RuleBasedTransactionAttribute.PREFIX_ISOLATION + "DEFAULT");
    //        return transactionAttribute;
    //    }
    //
    //    private TransactionAttribute readOnlyTx() {
    //        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
    //        List<RollbackRuleAttribute> rollbackRules = new ArrayList<>();
    //
    //        transactionAttribute.setRollbackRules(rollbackRules);
    //        transactionAttribute.setPropagationBehaviorName(RuleBasedTransactionAttribute.PREFIX_PROPAGATION + "REQUIRED");
    //        transactionAttribute.setIsolationLevelName(RuleBasedTransactionAttribute.PREFIX_ISOLATION + "DEFAULT");
    //        transactionAttribute.setReadOnly(true);
    //        return transactionAttribute;
    //    }
}
