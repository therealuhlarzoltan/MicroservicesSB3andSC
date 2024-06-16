package hu.therealuhlarzoltan.microservices.composit.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("hu.therealuhlarzoltan")
public class ProductCompositeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCompositeServiceApplication.class, args);
	}
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

