package org.qsheker.internpracticetask.repository;

import org.qsheker.internpracticetask.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{
    List<Weather> findAll();
}
