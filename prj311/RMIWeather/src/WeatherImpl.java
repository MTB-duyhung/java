
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WeatherImpl extends UnicastRemoteObject implements WeatherInterface {

    Weather weather;

    public WeatherImpl(Weather weather) throws RemoteException {
        this.weather = weather;
    }

    @Override
    public Weather getWeather() throws RemoteException {
        return weather;
    }
}
