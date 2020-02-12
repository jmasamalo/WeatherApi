package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiRestController {
    @Autowired
    WeatherRepository weatherRepository;
    
    @Autowired
    public WeatherApiRestController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
   
    //#1. delete all weather data
    @DeleteMapping("/erase")
    public void deleteAll() {
       weatherRepository.deleteAll();
   }
    
    //#2. delete a specific weather data
    @DeleteMapping( value="/erase", params= {"start","end","lat","lon"})
    public void eraseData(@RequestParam("start") String startDate,
            @RequestParam("end") String endDate, 
            @RequestParam("lat") float latitude,
            @RequestParam("lon") float longitude) throws Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sDate= dateFormatter.parse(startDate);
        Date eDate = dateFormatter.parse(endDate);
        weatherRepository.deleteData(sDate, eDate, latitude, longitude);
        //weatherRepository.deleteByLocationLatitudeAndLocationLongitudeAndDateRecordedBetween(latitude, longitude, sDate, eDate);
    } 

    //#3. add a weather data
    @PostMapping("/weather")
    public void saveWeather(@RequestBody Weather weather) {
        weatherRepository.save(weather);
    }
    
    //#4. return all weather data
    @GetMapping("/weather")
    public List<Weather> getAll() {
        List<Weather> data = weatherRepository.findAll();
        if(data != null && !data.isEmpty()) {
            data.stream()
                .sorted()
                .collect(Collectors.toList());
        }
        return data;
    }
    
    //#5. return weather data filtered by date
    @GetMapping(value="/weather", params={"date"})
    public ResponseEntity<List<Weather>> getWeatherByDateRecorded(@RequestParam("date") String date) throws Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = dateFormatter.parse(date);
        List<Weather> data = weatherRepository.findByDateRecorded(dt);
        if(data == null || data.isEmpty()) {
            return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
        }
               
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    
    //#6. return weather data filtered by location coordinates
    @GetMapping(value="/weather", params={"lat","lon"})
    public ResponseEntity<List<Weather>> getWeatherByCcoordinates(@RequestParam("lat") float latitude, @RequestParam("lon") float longitude) {
        List<Weather> data =  weatherRepository.findByLocationLatitudeAndLocationLongitude(latitude, longitude);
        if(data == null || data.isEmpty()) {
            return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
        }
              
        return new ResponseEntity<>(data,HttpStatus.OK);
    } 
   
}
