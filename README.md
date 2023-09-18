# springboot-postgressql

Application.properties File

# DB Configuration

spring.datasource.url=jdbc:postgresql://localhost:5432/EmployeeDb
spring.datasource.username=postgres
spring.datasource.password=root

spring.datasource.initialization-mode=always
spring.datasource.initialize=true
spring.datasource.schema=classpath:/schema.sql
spring.datasource.continue-on-error=true

# JPA Configuration

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true

# Dependency Swaager-ui

    <dependency>
    		<groupId>org.springdoc</groupId>
    		<artifactId>springdoc-openapi-ui</artifactId>
    		<version>1.5.12</version>
    	</dependency>
    	<dependency>
    		<groupId>io.springfox</groupId>
    		<artifactId>springfox-swagger2</artifactId>
    		<version>2.7.0</version>
    	</dependency>
    	<dependency>
    		<groupId>io.springfox</groupId>
    		<artifactId>springfox-swagger-ui</artifactId>
    		<version>2.7.0</version>
    	</dependency>

# Dependency mapstruct-processor

    <dependency>
    		<groupId>org.mapstruct</groupId>
    		<artifactId>mapstruct-processor</artifactId>
    		<version>1.4.2.Final</version>
    	</dependency>
