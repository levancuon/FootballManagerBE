package org.example.footballmanagerdn.models.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class PlayerUserDto {
    @NotBlank
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date dob;

    private String homeTown;
    @NotNull
    private String performance;

    private Double height;

    private Double weight;
    private Double salary;

    private String ranking;

    private String abilityProfile;

    private String position;

    private String avatar;

    private String status;
    @NotNull
    @Email
    private String userEmail;
    @NotNull
    private String userPassword;
}
