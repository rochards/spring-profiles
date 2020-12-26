package com.rodrigo.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter // necessario adicionar o lombol
@Setter // se nao tiver getter e setter, essa classe nao vai funcionar
public class DBConfiguration {

    private String driverClassName; // usando o camelCase o spring ja entende que eh o driver-class-name
    private String url;
    private String username;
    private String password;

    @Profile("dev") // application-dev.properties
    @Bean // indica que isso sera exibido assim que a app estiver subindo
    public String testDataBaseConnection() {

        System.out.println("DB connection for DEV - H2");
        System.out.println(this.driverClassName);
        System.out.println(this.url);

        return "DB Connection to H2_TEST - Test instance";
    }

    @Profile("prod") // application-prod.properties
    @Bean // indica que isso sera exibido assim que a app estiver subindo
    public String productionDataBaseConnection() {

        System.out.println("DB connection for Production MySQL");
        System.out.println(this.driverClassName);
        System.out.println(this.url);

        return "DB Connection to MYSQL_PROD - Production instance";
    }
}


