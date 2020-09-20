package com.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author junlin_huang
 * @create 2020-09-13 上午2:40
 **/

public class BeanFactoryTest {

    @Test
    public void beanFactoryTest() {
        //1 声明Bean工厂
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("/ioc/spring-ioc-test.xml"));
        //2 声明后置处理类(处理占位符)
        PropertyPlaceholderConfigurer propertyPostProcessor = new PropertyPlaceholderConfigurer();
        propertyPostProcessor.setLocation(new ClassPathResource("/ioc/ioc-test.properties"));
        propertyPostProcessor.postProcessBeanFactory(beanFactory);
        //3 声明另一个后置处理类(处理yy-MM-dd到日期的转换)
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map customEditors = new HashMap();
        customEditors.put(java.util.Date.class,DatePropertyEditor.class);
        customEditorConfigurer.setCustomEditors(customEditors);
        customEditorConfigurer.postProcessBeanFactory(beanFactory);

        Student student = (Student) beanFactory.getBean("student");
        System.out.println(student);


    }

}

class DatePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}