package org.example.footballmanagerdn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dob;

    private String homeTown;

    private String performance;

    private Double height;

    private Double weight;
    private Double salary;

    private String ranking;

    private String abilityProfile;

    private String position;

    private String avatar;

    private String status;

    @OneToMany
    @JoinColumn(name="playerId")
    private Set<Salary> salaries;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false, unique = true)
    private User user;
}
