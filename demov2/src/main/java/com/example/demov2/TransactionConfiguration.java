package com.example.demov2;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/28 11:49
 * @Modified By:
 */
@Aspect
@Configuration
public class TransactionConfiguration {


    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.example.demov2.service.impl.*.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor advice() {

        DefaultTransactionAttribute REQUIRED = new DefaultTransactionAttribute();
        REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DefaultTransactionAttribute REQUIRED_READONLY = new DefaultTransactionAttribute();
        REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        REQUIRED_READONLY.setReadOnly(true);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("save*", REQUIRED);
        source.addTransactionalMethod("remove*", REQUIRED);
        source.addTransactionalMethod("update*", REQUIRED);
        source.addTransactionalMethod("read*", REQUIRED_READONLY);
        source.addTransactionalMethod("list*", REQUIRED_READONLY);
        source.addTransactionalMethod("count*", REQUIRED_READONLY);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor adviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, advice());
    }

}
