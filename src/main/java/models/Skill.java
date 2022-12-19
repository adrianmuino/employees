package models;

import java.util.*;

public class Skill {

    private String id;
    private String name;
    private String desc;

    public Skill(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    
    private static List<Skill> skills = Arrays.asList(
            new Skill("skill-1", "Development", "Ability to develop software products"),
            new Skill("skill-2", "UI Design", "Ability to design user interfaces"),
            new Skill("skill-3", "Marketing", "Ability to attract customers and create brand awareness")
    );

    public static Skill getById(String id) {
        return skills.stream().filter(skill -> skill.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public static List<Skill> getSkills() {
        return skills;
    }
}
