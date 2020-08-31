package com.redis;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author junlin_huang
 * @create 2020-08-19 下午11:26
 **/

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = MainApplication.class)
public class BasicTest {

}