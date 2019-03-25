import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientDummy {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        //TODO
        Object o = null;
        System.out.println(">>> Downloading stub");
        System.out.println(">>> " + o.getClass().getSimpleName());
    }
}
