# MultipleCassandraKeyspacesWithSingleSession

This is a sample project to demonstrate the using multiple Keyspaces with single session in SpringBoot application. The project demonstrates the usage of the two different keyspaces with Spring Data. It uses custom repository to write queries manually and edit keyspaces while wiriting queries. To run the project you need to have cassandra running and required keyspaces and tables created.

To make project run from scratch follow these steps:
docker run -p 9042:9042 -d cassandra //run cassandra container detached mode

cqlsh //connect to cassandra with default config (localhost:9042)

after you swithched to the cqlsh shell
run the sql commands on customers.sql file which is under src/main/resources directory.
