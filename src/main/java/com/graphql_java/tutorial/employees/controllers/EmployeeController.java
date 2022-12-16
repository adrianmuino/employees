package com.graphql_java.tutorial.employees.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import bookDetails.Employee;

@Controller
public class EmployeeController {
    @QueryMapping
    public Employee employeeById(@Argument String id) {
        return Employee.getById(id);
    }

    @QueryMapping
    public List<Employee> employees() {
        return Employee.getEmployees();
    }

    @MutationMapping
    public Employee addEmployee(@Argument String firstName,
                                @Argument String lastName,
                                @Argument String dob,
                                @Argument String email,
                                @Argument String skill,
                                @Argument String level,
                                @Argument Boolean active) {
        UUID uuid = UUID.randomUUID();
        return Employee.addEmployee(uuid.toString(), firstName, lastName, dob, email, skill, level, active);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument String id,
                                @Argument String firstName,
                                @Argument String lastName,
                                @Argument String dob,
                                @Argument String email,
                                @Argument String skill,
                                @Argument String level,
                                @Argument Boolean active) {
        return Employee.updateEmployee(id, firstName, lastName, dob, email, skill, level, active);
    }

    @MutationMapping
    public Employee deleteEmployee(@Argument String id) {
        return Employee.deleteEmployee(id);
    }
}