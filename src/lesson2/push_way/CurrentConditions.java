package lesson2.push_way;

public class CurrentConditions implements Observer,DisplayUpdate{

    private float temperature;
    private float humidity;
    private float pressure;
    private  WeatherData weatherData;

    public  CurrentConditions(WeatherData weatherData){
        //옵저버를 만들면서, 생성자 파라미터로 subject를 받고 옵저버가 주제에 등록을함
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }
    @Override
    public void update(float tempm, float humidity, float pressure) {
        this.temperature= tempm;
        this.humidity =humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditions _" +this);
    }
}
