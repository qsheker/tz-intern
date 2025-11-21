package org.qsheker.internpracticetask.api;

import org.qsheker.internpracticetask.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherViewController {

    private final WeatherService weatherService;

    public WeatherViewController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        var items = weatherService.findAll();
        model.addAttribute("title", "Weather Data");
        model.addAttribute("items", items);
        return "weather";
    }

    @GetMapping("/ping")
    public String ping(Model model){
        model.addAttribute("ping","Pong");
        return "pong";
    }
}