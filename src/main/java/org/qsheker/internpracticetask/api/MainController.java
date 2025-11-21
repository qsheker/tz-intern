package org.qsheker.internpracticetask.api;


import org.qsheker.internpracticetask.models.Health;
import org.qsheker.internpracticetask.models.Weather;
import org.qsheker.internpracticetask.service.HealthCheckService;
import org.qsheker.internpracticetask.service.WeatherService;
import org.qsheker.internpracticetask.web.dto.HealthDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
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
    public HealthDto health(){
        var healthDto = new HealthDto();
        Health health = healthCheckService.checkHealth();
        healthDto.setStatus(health.getHealth().name());
        return healthDto;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        var items = weatherService.findAll();

        model.addAttribute("name", "Weather Data");
        model.addAttribute("items", items);

        return "weather";
    }
    @PostMapping("/add")
    public Weather add(@RequestBody Weather weather){
        return weatherService.save(weather);
    }

}
