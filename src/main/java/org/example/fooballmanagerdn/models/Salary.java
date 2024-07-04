package org.example.fooballmanagerdn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Entity
@Component
@Data
@Table(name = "salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date startDate;
    @NotBlank
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date endDate;
    @NotBlank
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date hourPlay;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9])",message = "Enter a number")
    private Double abilitySalary;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9])",message = "Enter a number")
    private Double Bonus;
    @NotBlank
    private Double totalSalary;


}
