package com.springboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @description:
 * @author: Linhuang
 * @date: 2023-08-17 14:19
 */
@Configuration
@Import(ReallyBigCompanySharedContextConfiguration .class) // (1)
public class EarlyExitUnicornProjectContextConfiguration {
}