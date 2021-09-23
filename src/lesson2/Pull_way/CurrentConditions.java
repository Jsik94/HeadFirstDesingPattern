package lesson2.Pull_way;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditions implements Observer,DisplayUpdate {
    Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public  CurrentConditions(WeatherData weatherData){
        //옵저버를 만들면서, 생성자 파라미터로 subject를 받고 옵저버가 주제에 등록을함
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditions _" +this);
    }

    
    //pull 방식의 업데이트
    @Override
    public void update(Observable o, Object arg) {
        //해당 객체가 WeatherData 이하 즉 weatherData 이상의 기능이 있는지 확인
        if( o instanceof  WeatherData){
            //최소 WeatherData 이하의 서브클래스이므로 이건 업캐스팅임
            //데이터를 직접가져옴
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
