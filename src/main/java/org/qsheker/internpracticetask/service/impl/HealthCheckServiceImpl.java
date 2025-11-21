package org.qsheker.internpracticetask.service.impl;

import org.qsheker.internpracticetask.service.HealthCheckService;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    @Override
    public String checkHealth() {
        return "";
    }
}
