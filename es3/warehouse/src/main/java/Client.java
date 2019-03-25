import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collections;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        //TODO
        Registry registry = null;

        switch (args[0]) {
            case "0": //Dynamic from server
                dFromServer(registry);
                break;
            case "1": //Dynamic from client
                dFromClient(registry);
                break;
            default:
                return;

        }

    }

    private static void dFromServer(Registry registry) throws NotBoundException,RemoteException {

        //TODO
        Warehouse warehouse = null;

        //TODO
        double price = 0;
        System.out.println(">>> " + price);

        //TODO
        Product toaster = null;
        System.out.println(">>> " + toaster.getDescription());

        //TODO
        Product book = null;
        System.out.println(">>> " + book.getDescription());
    }

    private static void dFromClient(Registry registry) throws NotBoundException,RemoteException {

        //TODO
        Warehouse warehouse = null;

        MusicCD oos = new MusicCD("Origin of Symmetry", "Muse",
                "Taste Media", 12.0);

        //TODO

    }
}
