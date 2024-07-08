package org.example.footballmanagerdn.services;

import org.example.footballmanagerdn.models.DTO.PlayerDto;
import org.example.footballmanagerdn.models.DTO.PlayerFormCreateDto;
import org.example.footballmanagerdn.models.DTO.PlayerFormUpdateDto;
import org.example.footballmanagerdn.models.Player;
import org.example.footballmanagerdn.models.Salary;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.Optional;

public interface IPlayerService {
    Page<PlayerDto> findAll(int page, int size, String sort, String name, Double salaryMin, Double salaryMax, Long position, String status);

    void createPlayer(PlayerFormCreateDto playerFormCreateDto);

    void save(Player player);

    Optional<PlayerDto> findPlayerById(Long id);

    void updatePlayer(Long id, PlayerFormUpdateDto playerFormUpdateDto);

    void deletePlayer(Long id);

    void createSalary(Long playerId, Salary salary);

    Iterable<Salary> getSalaries(Long playerId);
}
