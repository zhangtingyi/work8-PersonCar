package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person {
    public ICar getCar() {
        return car;
    }

    public void setCar(ICar car) {
        this.car = car;
    }

    ICar car;

    void driver(){


        car.driver();

    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

        Person person=(Person)applicationContext.getBean("person");
        person.driver();

//        startMethod("com.test.Lesson","selectClass");

        //动态创建类，调用方法
        Class cls=Class.forName("com.test.Lesson");
        Method method=cls.getMethod("selectClass",String.class);

        Object object=cls.newInstance();

        method.invoke(object,"hibernate");

        BeanWrapper beanWrapper=new BeanWrapper(object);
        beanWrapper.setPropertyValue("name","小程序");
        String name=beanWrapper.getPropertyValue("name").toString();

        System.out.println(name);


    }

}
