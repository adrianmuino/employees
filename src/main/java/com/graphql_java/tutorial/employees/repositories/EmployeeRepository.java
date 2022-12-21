package com.graphql_java.tutorial.employees.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> deleteSingleById(String id);
}
