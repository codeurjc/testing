package es.codeurjc.rest.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	@Bean
	public UsersService usersService() {
		return new UsersService("Juan");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
