package es.codeurjc.test.web;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

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
