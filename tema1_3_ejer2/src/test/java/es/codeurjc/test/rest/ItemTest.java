package es.codeurjc.test.rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void itemAddTest() {

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
	
	
	
	@Test
	public void itemDeleteTest() {
		
		//Given
		Item item = new Item();
		item.setDescription("milk");
		item.setChecked(false);
		
		String response = given().
			contentType("application/json").
			body(item).
		when().
			post("/items/").asString();
		
		int id = from(response).get("id");
			
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
		String response = given().
			contentType("application/json").
			body("{\"description\":\"milk\",\"checked\":false }").
		when().
			post("/items/").asString();
		
		int id = from(response).get("id");
			
		//When
		when()
			.get("/items/{id}",id).
		then()
			.statusCode(200).
			body(
				"id", equalTo(id),
				"description", equalTo("milk"),
				"checked",equalTo(false));
		
		when()
			.get("/items/{id}",id).
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
		String response = given().
			contentType("application/json").
			body("{\"description\":\"milk\",\"checked\":false }").
		when().
			post("/items/").asString();
		
		String response2 = given().
				contentType("application/json").
				body("{\"description\":\"meet\",\"checked\":false }").
			when().
				post("/items/").asString();
		
		int id1 = from(response).get("id");
		int id2 = from(response2).get("id");
			
		//When
		when()
			.get("/items/").
		then()
			.statusCode(200).
			body(
				"id", hasItems(id1, id2),
				"description", hasItems("milk","meet"),
				"checked",hasItems(false));		
	}

}
