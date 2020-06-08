
import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;

public class CounterRunnable {

    private int counter = 0;
    private int arcAngle = 0;
    private boolean stop = false;

    public CounterRunnable() {
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getArcAngle() {
        return arcAngle;
    }

    public void setArcAngle(int arcAngle) {
        this.arcAngle = arcAngle;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

}
