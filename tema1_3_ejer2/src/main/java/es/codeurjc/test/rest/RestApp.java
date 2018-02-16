package es.codeurjc.test.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestApp {

	private static ConfigurableApplicationContext app;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestApp.class, args);
	}

	public static void start() {
		start(new String[] {});
	}

	private static void start(String[] args) {
		if (app == null) {
			app = SpringApplication.run(RestApp.class, args);
		}
	}

	public static void stop() {
		if (app != null) {
			app.close();
		}
	}
}
