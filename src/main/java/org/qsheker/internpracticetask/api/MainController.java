package org.qsheker.internpracticetask.api;


import org.qsheker.internpracticetask.models.Health;
import org.qsheker.internpracticetask.models.Weather;
import org.qsheker.internpracticetask.service.HealthCheckService;
import org.qsheker.internpracticetask.service.WeatherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    private final HealthCheckService healthCheckService;
    private final WeatherService weatherService;

    public MainController(HealthCheckService healthCheckService, WeatherService weatherService) {
        this.healthCheckService = healthCheckService;
        this.weatherService = weatherService;
    }

    @GetMapping("/ping")
    public String ping(Model model){
        model.addAttribute("ping","Pong");
        return "pong";
    }

    @GetMapping("/health")
    public Health health(){
        return healthCheckService.checkHealth();
    }

    @GetMapping("/list")
    public String getAll(Model model){
        var items = weatherService.findAll();

        model.addAttribute("name", "Weather Data");
        model.addAttribute("items", items);

        return "weather";
    }
    @PostMapping
    public Weather add(@RequestBody Weather weather){
        return weatherService.save(weather);
    }

}
