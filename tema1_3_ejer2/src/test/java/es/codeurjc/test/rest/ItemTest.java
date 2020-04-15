package es.codeurjc.test.rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

public class ItemTest {
	
	@BeforeAll
	public static void setup() {
		RestApp.start();
	}
	
	@AfterAll
	public static void teardown() {
		RestApp.stop();
	}

	@Test
	public void itemAddTest() {
		
		given().
			contentType("application/json").
			body("{\"description\":\"milk\",\"checked\":false }").
		when().
			post("/items/").
		then().
			statusCode(201).
			body("description", equalTo("milk")).
			body("checked", equalTo(false));
	}
	
	@Test
	public void itemDeleteTest() {
		
		//Given
		Response response = given().
			contentType("application/json").
			body("{\"description\":\"milk\",\"checked\":false }").
		when().
			post("/items/").andReturn();
		
		int id = from(response.getBody().asString()).get("id");
			
		//When
		when().
			delete("/items/{id}",id).

		//Then	
		then().
			statusCode(200).
			body("id", equalTo(id));
		
		when()
			.get("/items/{id}",id).
		then()
			.statusCode(404);
	}
	
	@Test
	public void itemGetOneTest() {
		
		//Given
		Response response = given().
			contentType("application/json").
			body("{\"description\":\"milk\",\"checked\":false }").
		when().
			post("/items/").andReturn();
		
		int id = from(response.getBody().asString()).get("id");
			
		//When
		when()
			.get("/items/{id}",id).
		
		//Then
		then()
			.statusCode(200).
			body(
				"id", equalTo(id),
				"description", equalTo("milk"),
				"checked",equalTo(false));
		
	}
	
	@Test
	public void itemGetTest() {
		
		//Given
		Response response1 = given().
			contentType("application/json").
			body("{\"description\":\"milk\",\"checked\":false }").
		when().
			post("/items/").thenReturn();
		
		Response response2 = given().
				contentType("application/json").
				body("{\"description\":\"meet\",\"checked\":false }").
			when().
				post("/items/").thenReturn();
		
		int id1 = from(response1.getBody().asString()).get("id");
		int id2 = from(response2.getBody().asString()).get("id");
			
		//When
		when()
			.get("/items/").
		
		//Then
		then()
			.statusCode(200).
			body(
				"id", hasItems(id1, id2),
				"description", hasItems("milk","meet"),
				"checked",hasItems(false));		
	}

}
