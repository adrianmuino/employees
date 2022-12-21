package com.graphql_java.tutorial.employees.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql_java.tutorial.employees.repositories.SkillRepository;

import models.Skill;

@Controller
public class SkillController {
    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @QueryMapping
    public Skill skillById(@Argument String id) {
        return skillRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Skill> skills() {
        return skillRepository.findAll();
    }
}
