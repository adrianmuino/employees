package models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Employee {
    @Id
    private String id;
    @Field("f_name")
    private String firstName;
    @Field("l_name")
    private String lastName;
    private String dob;
    private String email;
    @Field("skill")
    private ObjectId skillId;
    private String level;
    private boolean active;

    public Employee(String firstName, String lastName, String dob, String email, ObjectId skillId, String level, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.skillId = skillId;
        this.level = level;
        this.active = active;
    }

    public String getId() {
        return id;
    }

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public ObjectId getSkillId() {
		return skillId;
	}

	public String getLevel() {
		return level;
	}

	public boolean isActive() {
		return active;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSkillId(ObjectId skillId) {
		this.skillId = skillId;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
