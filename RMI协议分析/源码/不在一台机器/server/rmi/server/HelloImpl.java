package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    private static final long serialVersionUID = 1L;

    protected HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello(String name) throws RemoteException {
	System.out.println("成功调用HelloImpl.sayHello()!");
        return "Hello " + name + " !";
    }
}
