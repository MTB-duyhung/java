
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StudentImpl extends UnicastRemoteObject implements IStudent {

    private Student student;

    protected StudentImpl(Student student) throws RemoteException {
        this.student = student;
    }

    @Override
    public void writeStudent() throws RemoteException {
        try {
            FileWriter writer = new FileWriter("sv.dat", true);
            writer.write(student.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Write success!");
    }

    @Override
    public Student getStudent() throws RemoteException {
        return student;
    }

    @Override
    public void setStudent(Student student) throws RemoteException {
        this.student = student;
    }
}
