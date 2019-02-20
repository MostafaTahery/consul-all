package co.nilin.spring.cloud.consulall;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class ConsulAllApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsulAllApplication.class).web(WebApplicationType.NONE).run(args);
	}

}
