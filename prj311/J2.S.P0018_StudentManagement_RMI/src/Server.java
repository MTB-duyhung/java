
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {
        Student student = new Student();
        StudentImpl studentImpl;

        try {
            studentImpl = new StudentImpl(student);
            LocateRegistry.createRegistry(9996);
            Naming.rebind("rmi://localhost:9996/myrmi", studentImpl);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
