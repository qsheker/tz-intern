package org.qsheker.internpracticetask.api;


import org.qsheker.internpracticetask.models.Health;
import org.qsheker.internpracticetask.models.Weather;
import org.qsheker.internpracticetask.service.HealthCheckService;
import org.qsheker.internpracticetask.service.WeatherService;
import org.qsheker.internpracticetask.web.dto.HealthDto;
import org.qsheker.internpracticetask.web.dto.WeatherRequestDto;
import org.springframework.web.bind.annotation.*;


@RestController
public class MainController {

    private final HealthCheckService healthCheckService;
    private final WeatherService weatherService;

    public MainController(HealthCheckService healthCheckService, WeatherService weatherService) {
        this.healthCheckService = healthCheckService;
        this.weatherService = weatherService;
    }

    @GetMapping("/health")
    public HealthDto health(){
        var healthDto = new HealthDto();
        Health health = healthCheckService.checkHealth();
        healthDto.setStatus(health.getHealth().name());
        return healthDto;
    }

    @PostMapping("/add")
    public Weather add(@RequestBody WeatherRequestDto dto){
        var weather = Weather.builder()
                .city(dto.getCity())
                .temperature(dto.getTemperature())
                .build();
        return weatherService.save(weather);
    }

}
