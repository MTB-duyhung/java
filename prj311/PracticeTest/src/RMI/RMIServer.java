/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Admin
 */
public class RMIServer {
    public static void main(String[] args) {
        String serviceName = "rmi://localhost:1110/EmpServer";
        Implementation server;
        try {
            server = new Implementation();
            LocateRegistry.createRegistry(1110);
            Naming.rebind(serviceName, server);
            System.out.println("Service " + serviceName + " is running.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
