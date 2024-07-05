package org.example.fooballmanagerdn.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Entity
@Table(name = "salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private Date startDate;
    @NotNull
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private Date endDate;
    @NotNull
    private Double hourPlay;
    @NotNull
    @Pattern(regexp = "(^$|[0-9])",message = "Enter a number")
    private Double abilitySalary;
    @NotNull
    @Pattern(regexp = "(^$|[0-9])",message = "Enter a number")
    private Double Bonus;
    @NotNull
    private Double totalSalary;

    public Salary() {
    }

    public Salary(Long id, Date startDate, Date endDate, Double hourPlay, Double abilitySalary, Double bonus, Double totalSalary) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hourPlay = hourPlay;
        this.abilitySalary = abilitySalary;
        Bonus = bonus;
        this.totalSalary = totalSalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getHourPlay() {
        return hourPlay;
    }

    public void setHourPlay(Double hourPlay) {
        this.hourPlay = hourPlay;
    }

    public Double getAbilitySalary() {
        return abilitySalary;
    }

    public void setAbilitySalary(Double abilitySalary) {
        this.abilitySalary = abilitySalary;
    }

    public Double getBonus() {
        return Bonus;
    }

    public void setBonus(Double bonus) {
        Bonus = bonus;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
