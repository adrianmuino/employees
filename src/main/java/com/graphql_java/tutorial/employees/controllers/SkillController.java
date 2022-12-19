package com.graphql_java.tutorial.employees.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import models.Skill;

@Controller
public class SkillController {
    @QueryMapping
    public Skill skillById(@Argument String id) {
        return Skill.getById(id);
    }

    @QueryMapping
    public List<Skill> skills() {
        return Skill.getSkills();
    }
}
