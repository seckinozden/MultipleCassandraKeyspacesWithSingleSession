package com.seckin.sscustomers.repository;

import com.seckin.sscustomers.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerExtendedRepository {

  List<Customer> getAllCustomers(String keyspace);

  List<Customer> getCustomerById(String keyspace, String id);

  Optional<Customer> addCustomer(String keyspace, Customer customer);

  Optional<Customer> updateCustomer(String keyspace, Integer id, Customer customer);
}
