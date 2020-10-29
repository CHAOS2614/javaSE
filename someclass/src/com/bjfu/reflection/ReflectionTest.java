package com.bjfu.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Chao Huaiyu
 * @date 2020/10/29
 */
public class ReflectionTest {

    @Test
    public void reflectionTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<Person> personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object object = constructor.newInstance("tom", 12);
        Person person = (Person) object;
        System.out.println(person.toString());

        Field age =  personClass.getDeclaredField("age");
        age.set(person,10);
        System.out.println(person.toString());

        Method show = personClass.getDeclaredMethod("show");
        show.invoke(person);
    }
}
