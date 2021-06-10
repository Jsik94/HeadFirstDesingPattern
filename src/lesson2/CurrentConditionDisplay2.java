package lesson2;

import lesson2.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay2 implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    //생성시 기존 weatherData를 가져와 등록까지 시킴
    public CurrentConditionDisplay2(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }


    @Override
    public void display() {
        System.out.println("Current Conditions - temp : " + temperature+ "F degrees , humidity : "+ humidity+
                "% ");
    }


    @Override
    public void update(Observable o, Object arg) {

        // A instance of B : 객체 A가 B 클래스의 형식으로 변환이 되는지 확인
        if(o instanceof WeatherData2){
            WeatherData2 weatherData2 = (WeatherData2) o;
            this.temperature = temperature;
            this.humidity =humidity;
            display();
        }
    }
}
