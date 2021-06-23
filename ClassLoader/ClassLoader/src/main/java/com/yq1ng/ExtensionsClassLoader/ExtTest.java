package com.yq1ng.ExtensionsClassLoader;

import com.sun.java.accessibility.AccessBridge;

/**
 * @author ying
 * @Description
 * @create 2021-06-15 11:22 AM
 */

public class ExtTest {
    public static void main(String[] args) {
        System.out.println(AccessBridge.class.getClassLoader());
    }
}
