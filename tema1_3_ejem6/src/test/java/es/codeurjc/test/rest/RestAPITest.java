package es.codeurjc.test.rest;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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


