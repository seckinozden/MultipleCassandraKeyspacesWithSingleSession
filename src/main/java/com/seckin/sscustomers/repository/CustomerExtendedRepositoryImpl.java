package com.seckin.sscustomers.repository;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.set;

import com.datastax.driver.core.querybuilder.Clause;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Update;
import com.seckin.sscustomers.model.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.data.cassandra.core.CassandraTemplate;

public class CustomerExtendedRepositoryImpl implements CustomerExtendedRepository {

  private final CassandraTemplate cassandraTemplate;

  public CustomerExtendedRepositoryImpl(CassandraTemplate cassandraTemplate) {
    this.cassandraTemplate = cassandraTemplate;
  }

  public List<Customer> getAllCustomers(String keyspace) {
    Select query = QueryBuilder.select().from(keyspace, "customer");
    return cassandraTemplate.select(query, Customer.class);
  }

  public List<Customer> getCustomerById(String keyspace, String id) {
    Clause clause = QueryBuilder.eq("customer_id", Integer.parseInt(id));

    Select.Where select = QueryBuilder
        .select()
        .from(keyspace, "customer")
        .where()
        .and(clause);

    return cassandraTemplate.select(select, Customer.class);
  }

  public Optional<Customer> addCustomer(String keyspace, Customer customer) {

    Insert insert = QueryBuilder.insertInto(keyspace, "customer")
        .value("customer_id", customer.getId())
        .value("customer_name", customer.getName())
        .value("customer_address", customer.getAddress());

    boolean result = cassandraTemplate.getCqlOperations().execute(insert);

    if (result) {
      return Optional.of(customer);
    }

    return Optional.empty();
  }


  public Optional<Customer> updateCustomer(String keyspace, Integer id, Customer customer) {

    Update.Where updateQuery = QueryBuilder.update(keyspace, "customer").with(set("customer_name",
        customer.getName())).and(set(
        "customer_address", customer.getAddress())).where(eq("customer_id", id));

    boolean result = cassandraTemplate.getCqlOperations().execute(updateQuery);
    if (result) {
      return Optional.of(customer);
    }

    return Optional.empty();
  }
}
