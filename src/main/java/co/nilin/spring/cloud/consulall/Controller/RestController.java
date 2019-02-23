package co.nilin.spring.cloud.consulall.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate;
    }

    public Optional<URI> serviceUrl() {
        return discoveryClient.getInstances("myApp")
                .stream()
                .map(serviceInstance -> serviceInstance.getUri())
                .findFirst();
    }

    @GetMapping("/discoveryClient")
    public String discoveryPing() throws RestClientException, ServiceUnavailableException {
        URI service = serviceUrl()
                .map(s -> s.resolve("/ping"))
                .orElseThrow(ServiceUnavailableException::new);
        return restTemplate.getForEntity(service, String.class).getBody();
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/my-health-check")
    public ResponseEntity<String> myCustomCheck(){
        String message="Testing My Health Function";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
