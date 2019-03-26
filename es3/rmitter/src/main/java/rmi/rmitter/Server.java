package rmi.rmitter;

import rmi.rmitter.control.Controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException {
        Controller controller = new Controller();
        System.out.println(">>> Controller exported");

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("controller", controller);
    }
}
