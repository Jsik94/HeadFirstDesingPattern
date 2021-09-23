package lesson2.Pull_way;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;



    WeatherData(){
        //만들필요가 없다 상속받아쓰면 돼서
//        lst = new ArrayList<>();
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature =temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged(){
        //observable 의 상태를 전환 하는 토글키
        setChanged();
        notifyObservers();
    }
}
