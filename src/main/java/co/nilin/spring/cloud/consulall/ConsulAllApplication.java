package co.nilin.spring.cloud.consulall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulAllApplication.class,args);
	}

}
