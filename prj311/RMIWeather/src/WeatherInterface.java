
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WeatherInterface extends Remote {

    public Weather getWeather() throws RemoteException;
}
