package io.github.igorcossta.microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Microservice2Application {
    private final DiscoveryClient discoveryClient;

    public Microservice2Application(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("microservice2-endpoint")
    public String microservice2() {
        List<ServiceInstance> instances = discoveryClient.getInstances("microservice1");
        ServiceInstance serviceInstance = instances.get(0);
        String url = serviceInstance.getUri() + "/microservice1-endpoint";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Microservice2Application.class, args);
    }

}
