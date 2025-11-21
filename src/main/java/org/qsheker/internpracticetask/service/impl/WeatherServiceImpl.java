package org.qsheker.internpracticetask.service.impl;

import org.qsheker.internpracticetask.models.Weather;
import org.qsheker.internpracticetask.repository.WeatherRepository;
import org.qsheker.internpracticetask.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {


    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public Weather save(Weather weather) {
        return weatherRepository.save(weather);
    }
}
