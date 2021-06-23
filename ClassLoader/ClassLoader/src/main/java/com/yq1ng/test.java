package com.yq1ng;

/**
 * @author ying
 * @Description
 * @create 2021-06-15 5:38 PM
 */

public class test {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
