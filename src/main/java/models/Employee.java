package models;

import java.util.*;

public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String skillId;
    private String level;
    private boolean active;

    public Employee(String id, String firstName, String lastName, String dob, String email, String skillId, String level, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.skillId = skillId;
        this.level = level;
        this.active = active;
    }

    private static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("employee-1", "Joanne", "Rowling", "11/30/2000", "adriantest@gmail.com", "skill-1", "Intermediate", true),
            new Employee("employee-2", "Herman", "Melville", "01/20/2000", "adriantest@gmail.com", "skill-1", "Intermediate", true),
            new Employee("employee-3", "Anne", "Rice", "03/31/2000", "adriantest@gmail.com", "skill-3", "Intermediate", true)
    ));

    public static Employee getById(String id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
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

	public String getSkillId() {
		return skillId;
	}

	public String getLevel() {
		return level;
	}

	public boolean isActive() {
		return active;
	}

	public static List<Employee> getEmployees() {
		return employees;
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

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

    public static Employee addEmployee(String id, String firstName, String lastName, String dob, String email, String skillId, String level, boolean active) {
        Employee employee = new Employee(id, firstName, lastName, dob, email, skillId, level, active);
        employees.add(employee);
        return employee;
    }

    public static Employee updateEmployee(String id, String firstName, String lastName, String dob, String email, String skillId, String level, boolean active) {
        Employee updated = null;
        try {
            updated = employees.stream().filter(employee -> employee.getId().equals(id)).findAny().get();
            updated.setFirstName(firstName);
            updated.setLastName(lastName);
            updated.setDob(dob);
            updated.setEmail(email);
            updated.setSkillId(skillId);
            updated.setLevel(level);
            updated.setActive(active);
        } catch (Exception e) {
            updated = null;
        }

        return updated;
    }

    public static Employee deleteEmployee(String id) {
        // TODO: Change to remove in DB
        Employee emp = getById(id);
        if (emp != null) {
            employees.remove(emp);
        }
        return emp;
    }
}
