package com.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理(jdk代理和cglib代理)
 *
 * @author junlin_huang
 * @create 2020-09-12 下午8:31
 **/

public class DynamicProxyTest {


    /**
     * 使用jdk动态代理
     * 要求:被代理的类要实现某个接口
     * <p>
     * 为两个接口的实现类 同时生成动态代理对象 此代理两个实现类对象所做的事情是一样的
     */
    @Test
    public void jdkDynamicProxyTest() {
        Animal animal = (Animal) Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(),
                new Class[]{Animal.class},
                new LogInvocationHandler(new Pig()));
        animal.sleep();

        Person person = (Person) Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(),
                new Class[]{Person.class},
                new LogInvocationHandler(new Man()));
        person.sleep();
    }


    /**
     * 使用cglib动态代理 使用字节码增强技术 最终会创建一个被代理对象的子类
     * <p>
     * 为某个实现类生成cglib动态代理对象 此代理两个实现类对象所做的事情是一样的
     */
    @Test
    public void cglibDynamicProxyTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Pig.class);
        enhancer.setCallback(new LogCallback());
        Pig pig = (Pig) enhancer.create();
        pig.sleep();


        enhancer.setSuperclass(Man.class);
        enhancer.setCallback(new LogCallback());
        Man man = (Man) enhancer.create();
        man.sleep();
    }

}

/**
 * 这个实现类用于为jdk动态代理对象添加逻辑 这里简单的为代理对象添加日志
 */
class LogInvocationHandler implements InvocationHandler {

    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("sleep")) {
            System.out.println("要睡觉了");
            return method.invoke(target, args);
        }
        return null;
    }
}

class LogCallback implements MethodInterceptor {


    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName().equals("sleep")) {
            System.out.println("要睡觉了");
            return proxy.invokeSuper(object, args);
        }
        return null;
    }
}


interface Animal {
    void sleep();
}

class Pig implements Animal {

    public void sleep() {
        System.out.println("猪睡着了");
    }
}

interface Person {
    void sleep();
}

class Man implements Person {

    public void sleep() {
        System.out.println("人睡着了");
    }
}