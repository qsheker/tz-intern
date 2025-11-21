package org.qsheker.internpracticetask.web.dto;

import lombok.Data;

@Data
public class WeatherRequestDto {
    private String city;
    private Integer temperature;
}
