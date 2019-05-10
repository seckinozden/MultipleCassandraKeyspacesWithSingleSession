package com.seckin.sscustomers.repository;

import com.seckin.sscustomers.model.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CustomerRepository extends CassandraRepository<Customer, Integer>, CustomerExtendedRepository {
}
