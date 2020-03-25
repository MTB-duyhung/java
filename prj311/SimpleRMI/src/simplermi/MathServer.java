/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplermi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Admin
 */
public class MathServer {

    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1090/MathServer";
        MathServices server;
        try {
            server = new Mathematician();
            LocateRegistry.createRegistry(1090);
//            Runtime rt = Runtime.getRuntime();
//            rt.exec("rmiregistry.exe");
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + " is running.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
