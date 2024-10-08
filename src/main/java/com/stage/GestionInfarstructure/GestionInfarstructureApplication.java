package com.stage.GestionInfarstructure;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GestionInfarstructureApplication {

	private static final Logger log = LoggerFactory.getLogger(GestionInfarstructureApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(GestionInfarstructureApplication.class);
		Environment env = app.run(args).getEnvironment();

		String protocol = "http";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}

		log.info("\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t"
						+ "Local: \t\t{}://localhost:{}\n\t"
						+ "External: \t{}://{}:{}\n\t"
						+ "Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name", "GestionInfarstructure"),
				protocol,
				env.getProperty("server.port", "8080"),
				protocol,
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port", "8080"),
				env.getActiveProfiles());
	}
}
