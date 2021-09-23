package lesson2.Pull_way;

public class PushSimulator {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();


        CurrentConditions currentConditions = new CurrentConditions(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);


        weatherData.setMeasurements(80,64,30.4f);
        weatherData.setMeasurements(80,64,30.4f);
        weatherData.setMeasurements(80,64,30.4f);

    }

}
