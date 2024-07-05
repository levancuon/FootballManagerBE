package org.example.footballmanagerdn.models.DTO;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public interface PlayerDto {
    Long getId();
    String getName();
    Double getSalary();
    Date getDob();
    String getHomeTown();
    String getPerformance();
    Double getHeight();
    Double getWeight();
    String getRanking();
    String getAbilityProfile();
    String getPosition();
    String getAvatar();
    String getStatus();
}
