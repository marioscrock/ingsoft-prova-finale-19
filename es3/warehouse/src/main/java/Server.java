import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        System.setProperty("java.security.policy", "stupid.policy");
        System.setSecurityManager(new SecurityManager());

        System.out.println("Creating new warehouse");
        WarehouseImpl warehouse = new WarehouseImpl(new Book("BackupBook",
                "424242", 66.99));
        warehouse.add("toaster", new Product("SuperToaster", 23.95));

        System.out.println("Binding");
        Registry registry = LocateRegistry.getRegistry();
        registry.rebind("warehouse", warehouse);

        System.out.println("Waiting for invocations...");
    }
}
