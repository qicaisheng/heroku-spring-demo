package com.qicaisheng.herokuspringdemo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping
    public List<Customer> findAll() {
        return customerRepository.findAll();
    } 

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

}
