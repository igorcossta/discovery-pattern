package io.github.igorcossta.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Microservice1Application {
    private final Environment environment;

    public Microservice1Application(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("microservice1-endpoint")
    public String microservice1() {
        return "I am a REST API in microservice 1 at port " + environment.getProperty("local.server.port");
    }

    public static void main(String[] args) {
        SpringApplication.run(Microservice1Application.class, args);
    }

}
