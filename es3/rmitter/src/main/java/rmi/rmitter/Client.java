package rmi.rmitter;

import rmi.rmitter.control.RemoteController;
import rmi.rmitter.view.TextView;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry();

        for (String name : registry.list()) {
            System.out.println("Registry bindings: " + name);
        }
        System.out.println("\n");

        // gets a reference for the remote controller
        RemoteController controller = (RemoteController) registry.lookup("controller");

        // creates and launches the view
        new TextView(controller).run();
    }
}
