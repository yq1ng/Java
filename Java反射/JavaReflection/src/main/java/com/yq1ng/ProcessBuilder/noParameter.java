package com .yq1ng.ProcessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author ying
 * @Description
 * @create 2021-06-23 8:01 PM
 */

public class noParameter {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        Class<?> processBuilder = Class.forName("java.lang.ProcessBuilder");
        //  由于 ProcessBuilder 构造函数均有参，且 className.newInstance() 没有参数 , 只能调用无参构造函数
        //  所以此处用了 getConstructor() 方法来调用有参函数
        //  参数类型为数组
//        Object obj = processBuilder.getConstructor(List.class).newInstance(Arrays.asList("id"));
        //  有参数的话需要将参数装到一个数组实例中
        Object arg[] = new Object[]{new String[]{"ls","-al"}};
        Object obj = processBuilder.getConstructor(String[].class).newInstance(arg);

        Method start = processBuilder.getMethod("start");
        Process p = (Process) start.invoke(obj);
        InputStream inputStream = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
}
