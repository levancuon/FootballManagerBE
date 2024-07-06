package org.example.footballmanagerdn.models.DTO;


import org.example.footballmanagerdn.models.Position;
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
    String getAvatar();
    String getStatus();
    Position getPosition();
}
