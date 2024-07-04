package org.example.fooballmanagerdn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Component
@Data
@Table(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dob;
    @NotBlank
    private Double salary;
    @NotBlank
    private String homeTown;
    @NotBlank
    private String abilityProfile;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false, unique = true)
    private User user;
    @OneToMany
    @JoinColumn(name = "coachId")
    private ArrayList<Salary> salaries;
}
