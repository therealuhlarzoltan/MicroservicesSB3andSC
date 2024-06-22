package hu.therealuhlarzoltan.microservices.core.product;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
@ComponentScan("hu.therealuhlarzoltan")
public class ProductServiceApplication {
	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =
				SpringApplication.run(ProductServiceApplication.class, args);
		String mongodDbHost =
				ctx.getEnvironment().getProperty("spring.data.mongodb.host");
		String mongodDbPort =
				ctx.getEnvironment().getProperty("spring.data.mongodb.port");
		LOG.info("Connected to MongoDb: " + mongodDbHost + ":" +
				mongodDbPort);
	}
}


