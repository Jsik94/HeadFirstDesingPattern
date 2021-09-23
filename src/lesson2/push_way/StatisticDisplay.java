package lesson2.push_way;

public class StatisticDisplay implements Observer,DisplayUpdate{


    private float temperature;
    private float humidity;
    private float pressure;
    private  WeatherData weatherData;

    public StatisticDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(float tempm, float humidity, float pressure) {
        display();
    }

    @Override
    public void display() {
        System.out.println("StatisticDisplay _" +this);
    }
}
