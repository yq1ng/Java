package com.yq1ng.UserDefineClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ying
 * @Description
 * @create 2021-06-15 5:05 PM
 */

public class testMyClassLoader {
    public static void main(String[] args) {
        //  指定路径
        myClassLoader myClassLoader = new myClassLoader("F:\\");
        try {
            //  指定加载文件名称
            Class c = myClassLoader.loadClass("Test");
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("methods: " + method.getName());
            }
            if (c != null) {
                try {
                    Object object = c.newInstance();
                    //  参数为 String ，为c.getDeclaredMethod指定参数类型准备
                    Class[] cArg = new Class[1];
                    cArg[0] = String.class;
                    Method method = c.getDeclaredMethod("test", cArg);
                    method.invoke(object, "yq1ng");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
