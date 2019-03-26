import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collections;
import java.util.prefs.Preferences;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        System.setProperty("java.security.policy", "stupid.policy");
        System.setSecurityManager(new SecurityManager());

        Registry registry = LocateRegistry.getRegistry();

        System.out.println("RMI registry bindings: ");
        for (String binding : registry.list()) {
            System.out.println(">>> " + binding);
        }

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

        Warehouse warehouse = (Warehouse) registry.lookup("warehouse");

        double price = warehouse.getPrice("SuperToaster");
        System.out.println(">>> " + price);

        Product toaster = warehouse.getProduct(Collections.singletonList("toaster"));
        System.out.println(">>> " + toaster.getDescription());

        System.out.println(">>> Downloading Book class from codebase");
        Product book = warehouse.getProduct(Collections.singletonList("let's see what happens when we get a book"));
        System.out.println(">>> " + book.getDescription());
    }

    private static void dFromClient(Registry registry) throws NotBoundException,RemoteException {

        Warehouse warehouse = (Warehouse) registry.lookup("warehouse");

        MusicCD oos = new MusicCD("Origin of Symmetry", "Muse",
                "Taste Media", 12.0);
        warehouse.add("muse-2", oos);
        System.out.println(">>> Server downloads MusicCD class from codebase");

        Product oos_copy = warehouse.getProduct(Collections.singletonList("muse-2"));
        System.out.println(">>> " + oos_copy.getDescription());
        System.out.println(">>> " + oos_copy.getClass().getSimpleName());
        System.out.println(">>> MusicCD returned is equal? " + oos_copy.equals(oos));

    }
}
