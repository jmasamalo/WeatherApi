package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WeatherRepository extends JpaRepository<Weather,Long> {
    
    @Query("DELETE FROM Weather w WHERE w.location.latitude=:latitude AND w.location.longitude=:longitude AND w.dateRecorded>=:startDate AND w.dateRecorded<=:endDate")
    public void eraseData(String startDate, String endDate, double latitude, double longitude);
    
    public List<Weather> findByDateRecorded(Date date);
    
    public List<Weather> findByLocationLatitudeAndLocationLongitude(double latitude, double longitude);
   
}
