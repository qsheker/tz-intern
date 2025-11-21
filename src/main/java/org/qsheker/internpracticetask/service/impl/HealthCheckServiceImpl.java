package org.qsheker.internpracticetask.service.impl;

import org.qsheker.internpracticetask.models.Health;
import org.qsheker.internpracticetask.models.HealthStatus;
import org.qsheker.internpracticetask.service.HealthCheckService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {

    private static final String DB_STATEMENT = "SELECT 1";
    private final DataSource dataSource;

    public HealthCheckServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Health checkHealth() {
        try {
            Connection con = dataSource.getConnection();
            Statement statement = con.createStatement();

            statement.execute(DB_STATEMENT);

            return Health.builder()
                    .health(HealthStatus.HEALTHY)
                    .build();

        } catch (SQLException e) {

            return Health.builder()
                    .health(HealthStatus.UNHEALTHY)
                    .build();
        }
    }
}
