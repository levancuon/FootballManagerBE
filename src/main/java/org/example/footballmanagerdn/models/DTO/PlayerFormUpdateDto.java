package org.example.footballmanagerdn.models.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class PlayerFormUpdateDto {
    @NotBlank
    private String name;

    @NotNull
    private Date dob;

    @NotNull
    private Double salary;

    private String homeTown;
    private String performance;

    private Double height;
    private Double weight;

    private String ranking;
    private String abilityProfile;
    private Long positionId;
    private MultipartFile avatar;
    private String status;
}
