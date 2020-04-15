package es.codeurjc.test.rest;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

/**
 *
 * @author mica
 */
public class RestAPITest {
    
    @BeforeAll
    public static void setup(){
        RestApp.start();
    }
    
    @AfterAll
    public static void teardown(){
        RestApp.stop();
    }
    
    @Test
    public void createNewItemTest(){
        
        given().
            request()
                .body("{ \"description\" : \"Leche\", \"checked\": false }")
                //.header("Content-Type", "application/json").
                .contentType(ContentType.JSON).
                
                
        when().
            post("http://localhost:8080/items/").
	    then().
	     	statusCode(201).
	     	body("id", equalTo(1));
        
    }
}


