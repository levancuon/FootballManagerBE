package org.example.footballmanagerdn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Data
@Table(name = "salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String week;


    private Double hourPlay;


    private Double abilitySalary;

    private Double bonus;

    private Double totalSalary;

    private Long playerId;
    private Long coachId;

}
