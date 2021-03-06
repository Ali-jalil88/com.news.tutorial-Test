package com.zyadeh.kamel.entities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.sql.DriverManager;
@Configuration
@ComponentScan(basePackages = "com.zyadeh.kamel")
public class AppConfig {
    @Autowired
    Environment environment;
    private JdbcTemplate jdbcTemplate;
@Bean
JdbcTemplate jdbcTemplate(){
    return new JdbcTemplate(dataSource());
}
@Autowired
    public AppConfig(Environment environment) {
        this.environment = environment;
    }
    private final String URL = "jdbc:postgresql://localhost:5432/news";
    private final String USER = "postgres";
    private final String DRIVER = "driver";
    private final String PASSWORD = "1234";
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        jdbcTemplate.setDataSource(driverManagerDataSource);
        return driverManagerDataSource;
    }
}
