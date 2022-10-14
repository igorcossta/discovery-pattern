package io.github.igorcossta.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Microservice1Application {

    @GetMapping("microservice1-endpoint")
    public String microservice1() {
        return "I am a REST API in microservice 1";
    }

    public static void main(String[] args) {
        SpringApplication.run(Microservice1Application.class, args);
    }

}
