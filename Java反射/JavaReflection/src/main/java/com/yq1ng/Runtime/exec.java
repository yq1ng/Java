package com.yq1ng.Runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ying
 * @Description
 * @create 2021-06-23 5:21 PM
 */

public class exec {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Class<?> runTime = Class.forName("java.lang.Runtime");
        Method getRuntime= runTime.getMethod("getRuntime");
        Method exec = runTime.getMethod("exec", String.class);
        Object obj = getRuntime.invoke(null);
        //  使用Process获取子进程的各种流
        //  win平台不能直接执行命令，需要 cmd.exe /c 命令
        Process p = (Process) exec.invoke(obj, "cmd.exe /c dir");
        InputStream inputStream = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
}
