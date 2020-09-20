package com.spring.ioc;


import lombok.*;

import java.util.Date;

/**
 * @author junlin_huang
 * @create 2020-09-13 上午2:43
 **/

@Setter
@Getter
@ToString
public class Student {

    public Student() {

    }

    private int age;

    private String name;

    private Date birthday;
}