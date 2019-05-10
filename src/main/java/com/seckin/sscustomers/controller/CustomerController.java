package com.seckin.sscustomers.controller;

import com.seckin.sscustomers.model.Customer;
import com.seckin.sscustomers.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @GetMapping("/")
  public String welcome() {
    return "Welcome to Customers";
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @GetMapping("/DE/customers")
  public List<Customer> getAllGermanCustomers() {
    return customerService.getAllCustomers("seckin_de");
  }

  @GetMapping("/TR/customers")
  public List<Customer> getAllTurkishCustomers() {
    return customerService.getAllCustomers("seckin_tr");
  }

  @GetMapping("/DE/customers/{id}")
  public List<Customer> getGermanCustomersById(@PathVariable("id") String id) {
    return customerService.getCustomerById("seckin_de", id);
  }

  @GetMapping("/TR/customers/{id}")
  public List<Customer> getTurkishCustomersById(@PathVariable("id") String id) {
    return customerService.getCustomerById("seckin_tr", id);
  }

  @PostMapping("/DE/customers/update/{id}")
  public Customer updateGermanCustomerById(@PathVariable("id") String id, @RequestBody Customer customer) {
    return customerService.updateCustomer("seckin_de", id, customer);
  }

  @PostMapping("/TR/customers/update/{id}")
  public Customer updateTurkishCustomerById(@PathVariable("id") String id, @RequestBody Customer customer) {
    return customerService.updateCustomer("seckin_tr", id, customer);
  }

  @PostMapping("/DE/add")
  public Customer createGermanCustomer(@RequestBody Customer customer) {
    return customerService.saveCustomer("seckin_de", customer);
  }

  @PostMapping("/TR/add")
  public Customer createTurkishCustomer(@RequestBody Customer customer) {
    return customerService.saveCustomer("seckin_tr", customer);
  }

}
