package com.graphql_java.tutorial.employees.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql_java.tutorial.employees.repositories.EmployeeRepository;
import com.graphql_java.tutorial.employees.repositories.SkillRepository;

import models.Employee;
import models.Skill;

@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;

    public EmployeeController(EmployeeRepository employeeRepository, 
                              SkillRepository skillRepository) {
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
    }

    @QueryMapping
    public Employee employeeById(@Argument String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    @MutationMapping
    public Employee addEmployee(@Argument String firstName,
                                @Argument String lastName,
                                @Argument String dob,
                                @Argument String email,
                                @Argument String skillId,
                                @Argument String level,
                                @Argument Boolean active) {
        Skill skill = skillRepository.findById(skillId).orElse(null);
        if(skill == null){
            return null;
        }
        Employee emp = new Employee(firstName, lastName, dob, email,
                                    new ObjectId(skillId), level, active);
        return employeeRepository.insert(emp);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument String id,
                                   @Argument String firstName,
                                   @Argument String lastName,
                                   @Argument String dob,
                                   @Argument String email,
                                   @Argument String skillId,
                                   @Argument String level,
                                   @Argument Boolean active) {
        /*
        * Optimally you would only issue one query -> findOneAndUpdate()
        * but implementing such a method with Spring Data MongoDB repositories
        * only allows for returning an integer or a void, objects are not
        * allowed. Hence, to implement such a method we'd have to restructure
        * this project to not use Spring Data MongoDB repositories, and instead 
        * use the MongoTemplate class.
        */
        Employee emp = employeeRepository.findById(id).orElse(null);
        if(emp == null){
            return null;
        }
        
        Skill skill = skillRepository.findById(skillId).orElse(null);
        if(skill == null){
            return null;
        }

        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setDob(dob);
        emp.setEmail(email);
        emp.setSkillId(new ObjectId(skillId));
        emp.setLevel(level);
        emp.setActive(active);
        return employeeRepository.save(emp);
    }

    @MutationMapping
    public Employee deleteEmployee(@Argument String id) {
        return employeeRepository.deleteSingleById(id).orElse(null);
    }

    @SchemaMapping
    public Skill skill(Employee emp) {
        return skillRepository.findById(emp.getSkillId().toString()).orElse(null);
    }
}
