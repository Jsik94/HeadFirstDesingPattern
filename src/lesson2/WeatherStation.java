package lesson2;

public class WeatherStation {
    public static void main(String[] args){

        WeatherData weatherData = new WeatherData();


        CurrentConditionDisplay2 currentConditionDisplay = new CurrentConditionDisplay2(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(90,65,30.4f);
        weatherData.setMeasurements(80,65,29.2f);



    }
}
