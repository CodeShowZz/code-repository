package com.springboot.configuration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-08-17 14:26
 */
public class IsRelationalDatabaseCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {  // (1)
        return oracleJdbcDriverOnClassPath() && databaseUrlSet(context); // (2)
    }

    private boolean databaseUrlSet(ConditionContext context) { // (3)
        return context.getEnvironment().containsProperty("spring.datasource.url");
    }

    private boolean oracleJdbcDriverOnClassPath() { // (4)
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}