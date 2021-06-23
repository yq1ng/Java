package com.yq1ng.BootstrapClassLoader;

import java.net.URL;

/**
 * @author ying
 * @Description
 * @create 2021-06-15 10:51 AM
 */

public class BootStrapLoadInfo {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        System.out.println("========================================================");
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
