package lesson2.push_way;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> lst;
    private float temperature;
    private float humidity;
    private float pressure;


    WeatherData() {
        lst = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        lst.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

        if (lst.indexOf(o) >= 0) {
            lst.remove(o);
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void notifyObservers() {

        for(Observer o : lst){
            o.update(this.temperature,this.humidity,this.pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity,float pressure){
        this.temperature =temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged(){
        notifyObservers();
    }
}
