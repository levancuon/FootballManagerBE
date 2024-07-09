package org.example.footballmanagerdn.services;


import org.example.footballmanagerdn.models.Coach;
import org.example.footballmanagerdn.models.DTO.CoachDTO;
import org.example.footballmanagerdn.models.DTO.CoachWithUserDTO;
import org.example.footballmanagerdn.models.Salary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface ICoachService {
    Page<CoachDTO> findAll(int page, int size,String name, String homeTown);
    Page<Coach> findAllCoach(Pageable pageable);
    Iterable<Coach> findAllCoach();
    Coach findById(Long id);

    void remove(Long id);

    void save(Coach coach);

    Iterable<Coach> findAllByNameContaining(String search);

    void createSalary(Long coachID, Salary salary);
}
