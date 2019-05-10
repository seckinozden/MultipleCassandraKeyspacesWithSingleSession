package com.seckin.sscustomers.service;

import com.seckin.sscustomers.model.Customer;
import com.seckin.sscustomers.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;

  public List<Customer> getAllCustomers(String keyspace) {
    return customerRepository.getAllCustomers(keyspace);
  }

  public List<Customer> getCustomerById(String keyspace, String id) {
    return customerRepository.getCustomerById(keyspace, id);
  }

  public Customer saveCustomer(String keyspace, Customer customer) {
    return customerRepository
        .addCustomer(keyspace, customer)
        .orElse(null);
  }

  public Customer updateCustomer(String keyspace, String id, Customer customer) {
    return customerRepository
        .updateCustomer(keyspace, Integer.parseInt(id), customer)
        .orElse(null);
  }

}
