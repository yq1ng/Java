package rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
    public static void main(String[] args) {
        try {
	    System.setProperty("java.rmi.server.hostname", "192.168.174.144");
	    Hello hello = new HelloImpl();
            //  默认监听端口就是1099
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://192.168.174.144:1099/hello", hello);
            System.out.println("Hello Server 启动成功，正在监听 1099 端口，等待客户端连接...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
