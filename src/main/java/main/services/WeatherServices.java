package main.services;

import main.model.dto.LocationDto;
import main.model.dto.WeatherDto;
import main.model.dto.WeatherReport;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherServices {
    Map<Integer, WeatherReport> weatherReportMap = new HashMap<>();


    public WeatherServices() {
        LocationDto locationDto1 = new LocationDto("Bogotá","Colombia","Cundinamarca");
        WeatherDto weatherDto1 = new WeatherDto(17.5,994.71,61);
        WeatherReport weatherReport = new WeatherReport(locationDto1,weatherDto1);
        weatherReportMap.put(1,weatherReport);
    }

    public WeatherReport getWeather(int id){
        return weatherReportMap.get(id);
    }

    public void saveWeather(int id, LocationDto locationDto){
        weatherReportMap.get(id).setLocation(locationDto);
    }

}
