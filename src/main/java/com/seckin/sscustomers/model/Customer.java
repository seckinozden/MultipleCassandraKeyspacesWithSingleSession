package com.seckin.sscustomers.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Data
public class Customer {

  @PrimaryKey("customer_id")
  Integer id;

  @Column("customer_name")
  String name;

  @Column("customer_address")
  String address;
}
