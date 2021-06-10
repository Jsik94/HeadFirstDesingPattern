package lesson2;

public class CurrentConditionDisplay implements Observer,DisplayElement{

    private float temperature;
    private float humidity;
    private Subject weatherData;


    //생성시 기존 weatherData를 가져와 등록까지 시킴
    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.println("Current Conditions - temp : " + temperature+ "F degrees , humidity : "+ humidity+
                "% ");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
