package uz.salikhdev.todoapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {


   /* @Bean
    public DataSource dataSource() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername("postgres");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/java_10");
        dataSource.setUsername("123");

        return dataSource;
    }*/


}
