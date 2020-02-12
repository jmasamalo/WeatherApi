package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface WeatherRepository extends JpaRepository<Weather,Long> {
    @Transactional
    @Modifying
    @Query( value = "DELETE FROM WEATHER WHERE LATITUDE=:latitude AND LONGITUDE=:longitude AND DATE_RECORDED BETWEEN :startDate AND :endDate", nativeQuery = true)
    public void deleteData(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("latitude") float latitude, @Param("longitude") float longitude);
    //public void deleteByLocationLatitudeAndLocationLongitudeAndDateRecordedBetween(float latitude, float longitude, Date  startDate, Date endDate);

    public List<Weather> findByDateRecorded(Date date);
    
    public List<Weather> findByLocationLatitudeAndLocationLongitude(float latitude, float longitude);
   
}
