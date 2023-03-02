package main.controller;

import com.google.gson.Gson;
import main.model.dto.LocationDto;
import main.model.dto.WeatherDto;
import main.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/weather")
public class WeatherController {

    WeatherServices weatherServices = new WeatherServices();

    @GetMapping("/{id}")
    public ResponseEntity<?> getLocationById(@PathVariable("id") int id) {
        return new ResponseEntity<>(new Gson().toJson(weatherServices.getWeather(id)), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<WeatherDto> saveWeather(@PathVariable("id") int id, @RequestBody LocationDto locationDto){
        weatherServices.saveWeather(id,locationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
       

}

