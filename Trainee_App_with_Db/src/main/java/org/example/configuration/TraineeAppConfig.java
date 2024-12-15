package org.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("org.example")
@PropertySource("application.properties")
public class TraineeAppConfig {

    @Value("${db.url}")
    private  String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;

    }
}
