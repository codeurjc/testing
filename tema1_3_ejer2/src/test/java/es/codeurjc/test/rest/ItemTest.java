package es.codeurjc.test.rest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.http.Header;

public class ItemTest {
	
	@BeforeClass
	public static void setup() {
		RestApp.start();
	}
	
	@AfterClass
	public static void teardown() {
		RestApp.stop();
	}

	@Test
	public void testItemAdd() {

		Item item = new Item();
		item.setDescription("milk");
		item.setChecked(false);
		
		given().
			contentType("application/json").
			body(item).
		when().
			post("/items/").
		then().
			statusCode(201).
			body("description", equalTo("milk")).
			body("checked", equalTo(false));
	}

}
