package com.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-08-17 11:13
 */
@Configuration
public class ReallyBigCompanySharedContextConfiguration {

    @Bean
    @Conditional(IsRelationalDatabaseCondition.class) // (1)
    public ReallyBigCompanyProprietaryFlywayClone flywayClone() {
        return new ReallyBigCompanyProprietaryFlywayClone(); // (2)
    }

}