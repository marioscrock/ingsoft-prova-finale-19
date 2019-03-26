import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientDummy {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        System.setProperty("java.security.policy", "stupid.policy");
        System.setSecurityManager(new SecurityManager());

        Registry registry = LocateRegistry.getRegistry();

        Object o = registry.lookup("warehouse");
        System.out.println(">>> Downloading stub");
        System.out.println(">>> " + o.getClass().getSimpleName());
    }
}
