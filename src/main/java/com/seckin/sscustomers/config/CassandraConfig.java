package com.seckin.sscustomers.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
@EnableAutoConfiguration
public class CassandraConfig extends AbstractCassandraConfiguration {

  @Override
  protected boolean getMetricsEnabled() {
    return false;
  }

  @Override
  protected String getKeyspaceName() {
    return "seckin_de";
  }
}
