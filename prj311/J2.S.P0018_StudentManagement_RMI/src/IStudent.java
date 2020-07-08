
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public interface IStudent extends Remote {

    void writeStudent() throws RemoteException;

    Student getStudent() throws RemoteException;

    void setStudent(Student student) throws RemoteException;
}
