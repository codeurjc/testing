package es.codeurjc.test.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebApp {

	private static ConfigurableApplicationContext app;
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApp.class, args);
    }
    
    public static void start() {
    	start(new String[] { "--server.port=9000" });
    }

	private static void start(String[] args) {
		if(app == null) {
    		app = SpringApplication.run(WebApp.class, args);
    	} 
	}    
	
	public static void stop() {
		if(app != null) {
			app.close();
		}
	}
}
