package com.qicaisheng.herokuspringdemo.demo;

import io.restassured.http.ContentType;
import io.restassured.mapper.TypeRef;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerControllerTest {
    
    @MockBean
    private CustomerRepository customerRepository;
    
    @Autowired
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(customerController);
        Mockito.when(customerRepository.findAll()).thenReturn(Collections.singletonList(new Customer("first", "second")));
    }

    @Test
    void shouldFindAllCustomers() {
        MockMvcResponse response = RestAssuredMockMvc.given().contentType(ContentType.JSON).get("/customers");

        List<Customer> customers = response.getBody().as(new TypeRef<List<Customer>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(customers.size()).isEqualTo(1);

    }


    @Test
    void shouldCreateCustomer() {
        MockMvcResponse response = RestAssuredMockMvc.given().contentType(ContentType.JSON)
                .body(new Customer("first", "second"))
                .post("/customers");

        Customer customer = response.getBody().as(Customer.class);

        Mockito.verify(customerRepository, Mockito.times(1)).save(customer);
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(customer).isNotNull();
    }
}
