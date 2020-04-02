package es.codeurjc.test.web;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikipediaTest {

	private WebDriver driver;

	@BeforeAll
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	public void setupTest() {
		driver = new ChromeDriver();
	}

	@AfterEach
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test() throws InterruptedException {
		
		driver.get("https://wikipedia.org");
        WebElement searchInput = driver.findElement(By.name("search"));

        Thread.sleep(2000);
        
        searchInput.sendKeys("Rick Astley");
        searchInput.submit();

        Thread.sleep(2000);
        
        WebElement link = driver.findElement(By.linkText("Rickrolling"));
        link.click();
        
        Thread.sleep(2000);

        boolean memeFound = driver.findElements(By.cssSelector("p"))
                .stream()
                .anyMatch(element -> element.getText().contains("meme"));

        assertTrue(memeFound, "Rickrolling page should contain meme word");
	}

}







