package com.yq1ng.AppClassLoader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author ying
 * @Description
 * @create 2021-06-15 11:33 AM
 */

public class AppLoaderInfo {
    public static void main(String[] args) {
        URLClassLoader appClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        URL[] urls = appClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
    }
}
