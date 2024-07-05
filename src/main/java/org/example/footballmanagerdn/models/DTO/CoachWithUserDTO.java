package org.example.footballmanagerdn.models.DTO;

import jakarta.validation.constraints.Size;
import org.example.footballmanagerdn.models.Salary;

import java.sql.Date;
import java.util.Set;

public class CoachWithUserDTO {
    private Long id;
    private String name;
    private Date dob;
    private Double salary;
    private String homeTown;
    private String abilityProfile;
    private String email;
    @Size(min=6,max=8)
    private String password;

    public CoachWithUserDTO() {
    }

    public CoachWithUserDTO(Long id, String name, Date dob, Double salary, String homeTown, String abilityProfile, String email, String password) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.homeTown = homeTown;
        this.abilityProfile = abilityProfile;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getAbilityProfile() {
        return abilityProfile;
    }

    public void setAbilityProfile(String abilityProfile) {
        this.abilityProfile = abilityProfile;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
