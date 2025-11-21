package org.qsheker.internpracticetask.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Health {
    private HealthStatus health;
}
