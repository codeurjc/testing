package es.codeurjc.test.tablonanuncios;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.openqa.selenium.remote.DesiredCapabilities.chrome;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnuncioTest {

	private static String sutURL;
	private static String eusURL;

	WebDriver driver;
	
	@BeforeAll
	public static void setupClass() {

		String sutHost = System.getenv("ET_SUT_HOST");
		if (sutHost == null) {
			sutURL = "http://localhost:8080/";
		} else {
			sutURL = "http://" + sutHost + ":8080/";
		}
		System.out.println("App url: " + sutURL);

		eusURL = System.getenv("ET_EUS_API");
		if (eusURL == null) {
			WebDriverManager.chromedriver().setup();
		}
	}

	@BeforeEach
	public void setupTest() throws MalformedURLException {
		String eusURL = System.getenv("ET_EUS_API");
		if (eusURL == null) {
			// Local Google Chrome
			driver = new ChromeDriver();
		} else {
			// Selenium Grid in ElasTest
			driver = new RemoteWebDriver(new URL(eusURL), chrome());
		}
	}
	
	@AfterEach
	public void teardown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void createTest() throws InterruptedException {
		
		driver.get(sutURL);
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Nuevo anuncio")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("nombre")).sendKeys("Anuncio nuevo con Selenium");
		driver.findElement(By.name("asunto")).sendKeys("Vendo moto");
		driver.findElement(By.name("comentario")).sendKeys("Un comentario muy largo...");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.linkText("Volver al tablón")).click();
		
		assertNotNull(driver.findElement(By.partialLinkText("Selenium")));
	}

}
