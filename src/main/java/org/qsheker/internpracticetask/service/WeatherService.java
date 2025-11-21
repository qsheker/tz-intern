package org.qsheker.internpracticetask.service;

import org.qsheker.internpracticetask.models.Weather;

import java.util.List;


public interface WeatherService {
    List<Weather> findAll();
    Weather save(Weather weather);
}
