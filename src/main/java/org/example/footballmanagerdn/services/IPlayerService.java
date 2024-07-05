package org.example.footballmanagerdn.services;

import org.example.footballmanagerdn.models.DTO.PlayerDto;
import org.example.footballmanagerdn.models.DTO.PlayerUserDto;
import org.example.footballmanagerdn.models.Player;
import org.springframework.data.domain.Page;

public interface IPlayerService {
    Page<PlayerDto> findAll(int page, int size, String sort, String name, Double salaryMin, Double salaryMax, String position, String status);

    void createPlayer(PlayerUserDto playerUserDto);
}
