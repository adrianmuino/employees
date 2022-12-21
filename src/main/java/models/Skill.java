package models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Skill {
    @Id
    private String id;
    private String name;
    private String desc;

    public Skill(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
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
}
