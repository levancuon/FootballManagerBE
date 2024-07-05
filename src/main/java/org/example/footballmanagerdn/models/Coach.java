package org.example.footballmanagerdn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


import java.sql.Date;

import java.util.Set;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private Date dob;
    @NotNull
    private Double salary;
    @NotBlank
    private String homeTown;
    @NotBlank
    private String abilityProfile;

    @OneToMany
    @JoinColumn(name="coachId")
    private Set<Salary> salaries;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false, unique = true)
    private User user;
    public Coach() {
    }

    public Coach(Long id, String name, Date dob, Double salary, String homeTown, String abilityProfile, Set<Salary> salaries, User user) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.homeTown = homeTown;
        this.abilityProfile = abilityProfile;
        this.salaries = salaries;
        this.user = user;
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

    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
