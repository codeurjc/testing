package es.codeurjc.test.web;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;

import org.junit.Test;

public class GoogleBooksAPITest {

	@Test
	public void test() {
		
   	  given().
	     param("q", "intitle:javascript").
	  when().
	     get("https://www.googleapis.com/books/v1/volumes").
	  then().
	     statusCode(200).
	     body("items.volumeInfo.title", hasItems(containsString(("Javascript"))));
	}
}
