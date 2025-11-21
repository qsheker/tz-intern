package org.qsheker.internpracticetask.service.impl;

import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void initData() {
        if (weatherRepository.count() == 0) {
            weatherRepository.save(new Weather("London", 20));
            weatherRepository.save(new Weather("Paris", 25));
            weatherRepository.save(new Weather("Berlin", 18));
            weatherRepository.save(new Weather("Almaty", 15));
        }
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
