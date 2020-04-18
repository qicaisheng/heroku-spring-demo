package com.qicaisheng.herokuspringdemo.demo;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloControllerTest {
    
    @Autowired
    private HelloController helloController;

    @Test
    void shouldReturnHelloWorld() {

        RestAssuredMockMvc.standaloneSetup(helloController);

        MockMvcResponse response = RestAssuredMockMvc.given().get("/hello");
        
        assertEquals(200, response.getStatusCode());
        assertEquals("hello world!", response.getBody().asString());
    }
}
