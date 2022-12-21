package com.graphql_java.tutorial.employees.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Skill;

public interface SkillRepository extends MongoRepository<Skill, String> {
    
}
