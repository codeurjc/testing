package es.codeurjc.tablonanuncios;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import es.codeurjc.test.tablonanuncios.WebApp;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class AnuncioTest {

	WebDriver driver;
	
	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
		WebApp.start();
	}
	
	@AfterClass
	public static void teardownClass() {
		WebApp.stop();
	}
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void createTest() throws InterruptedException {
		driver.get("http://localhost:8080/anuncio/nuevo_form");
		
		driver.findElement(By.name("nombre")).sendKeys("Anuncio nuevo con Selenium");
		driver.findElement(By.name("asunto")).sendKeys("Vendo moto");
		driver.findElement(By.name("comentario")).sendKeys("Un comentario muy largo...");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.linkText("Volver al tablón")).click();
		
		assertNotNull(driver.findElement(By.partialLinkText("Selenium")));
	}

}
