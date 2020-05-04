package es.codeurjc.test.tablonanuncios;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnuncioTest {

	private static String sutURL;
	private static String eusURL;

	private static Logger logger = LoggerFactory.getLogger(AnuncioTest.class);

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
	public void setupTest(TestInfo testInfo) throws MalformedURLException {

		logger.info("##### Start test: " + testInfo.getTestMethod().get().getName());

		String eusURL = System.getenv("ET_EUS_API");
		if (eusURL == null) {
			// Local Google Chrome
			driver = new ChromeDriver();
		} else {
			// Selenium Grid in ElasTest
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("browserId", testInfo.getTestMethod().get().getName());
			driver = new RemoteWebDriver(new URL(eusURL), capabilities);
		}
	}

	@AfterEach
	public void teardown(TestInfo testInfo) {
		if (driver != null) {
			driver.quit();
		}

		logger.info("##### Finish test: " + testInfo.getTestMethod().get().getName());
	}

	@Test
	public void createTest() throws InterruptedException {

		logger.info("Open page");

		driver.get(sutURL);

		Thread.sleep(2000);

		logger.info("Search link");
		driver.findElement(By.linkText("Nuevo anuncio")).click();

		Thread.sleep(2000);

		logger.info("Fill in form");
		driver.findElement(By.name("nombre")).sendKeys("Anuncio nuevo con Selenium");
		driver.findElement(By.name("asunto")).sendKeys("Vendo moto");
		driver.findElement(By.name("comentario")).sendKeys("Un comentario muy largo...");

		Thread.sleep(2000);

		logger.info("Submit");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		logger.info("Back to index");
		driver.findElement(By.linkText("Volver al tablón")).click();

		assertNotNull(driver.findElement(By.partialLinkText("Selenium")));
	}

	@Test
	public void deleteTest() throws InterruptedException {

		logger.info("Open page");
		driver.get(sutURL);

		Thread.sleep(2000);

		logger.info("Search link");
		driver.findElement(By.linkText("Pepe")).click();

		Thread.sleep(2000);

		logger.info("Delete");
		driver.findElement(By.linkText("Borrar")).click();

		Thread.sleep(2000);

		assertNull(driver.findElement(By.partialLinkText("Juan")));
	}

}
