package es.codeurjc.test.rest;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.http.ContentType;

/**
 *
 * @author mica
 */
public class RestAPITest {
    
    @BeforeClass
    public static void setup(){
        RestApp.start();
    }
    
    @AfterClass
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


