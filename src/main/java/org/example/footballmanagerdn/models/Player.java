package org.example.footballmanagerdn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private Date dob;
    @NotBlank
    private String homeTown;
    @NotBlank
    private String playingPosition;
    @NotBlank
    private String performance;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9])")
    private Double height;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9])")
    private Double weight;
    @NotBlank
    private String profileRank;
    @NotBlank
    private String avatar;
    @NotBlank
    private String status;

    @OneToMany
    @JoinColumn(name="playerId")
    private Set<Salary> salaries;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false, unique = true)
    private User user;
}
