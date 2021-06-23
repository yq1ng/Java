package com.yq1ng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ying
 * @Description
 * @create 2021-06-23 10:50 PM
 */

public class BypassSecurityChecks {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        Class<?> runtime = Class.forName("java.lang.Runtime");
        Constructor<?> runtimeDeclaredConstructor = runtime.getDeclaredConstructor();
        //  setAccessible 设置为 true 会取消Java安全检查，即可以访问到私有方法
        runtimeDeclaredConstructor.setAccessible(true);
        Method exec = runtime.getMethod("exec", String.class);
        Object obj = runtimeDeclaredConstructor.newInstance();
        Process p = (Process) exec.invoke(obj, "uname -a");
        InputStream inputStream = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
}
