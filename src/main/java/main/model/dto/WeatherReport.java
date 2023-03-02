package main.model.dto;

public class WeatherReport {
    LocationDto location;
    WeatherDto weather;

    public WeatherReport(LocationDto location, WeatherDto weather) {
        this.location = location;
        this.weather = weather;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }
}
