package com.yq1ng.ExtensionsClassLoader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author ying
 * @Description
 * @create 2021-06-15 11:15 AM
 */

public class ExtensionsLoaderInfo {
    public static void main(String[] args) {
        URLClassLoader extClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader().getParent();
        URL[] urls = extClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
    }
}
