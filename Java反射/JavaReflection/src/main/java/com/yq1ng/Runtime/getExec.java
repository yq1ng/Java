package com.yq1ng.Runtime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ying
 * @Description
 * @create 2021-06-23 4:33 PM
 */

public class getExec {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 1. 先找到java.lang.Runtime类
        Class<?> runtime = Class.forName("java.lang.Runtime");
        System.out.println("通过Class.forName（）找到 " + runtime);
        // 2. 找exec方法
        Method[] runtimeMethods = runtime.getMethods();
        for (Method runtimeMethod : runtimeMethods) {
            System.out.println(runtimeMethod);
        }
        // 3. invoke
        Object execObj = runtime.getMethod("exec", String.class).invoke(runtime.newInstance(),"pwd");
    }
}
