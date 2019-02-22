package co.nilin.spring.cloud.consulall;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class ConsulAllApplication {

	@RequestMapping(method = RequestMethod.GET,value = "/")
	public String show(){
		return "Hello";
	}


	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsulAllApplication.class).web(WebApplicationType.NONE).run(args);
	}

}
