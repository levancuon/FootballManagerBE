package org.example.footballmanagerdn.services.iml;


import org.example.footballmanagerdn.models.Coach;
import org.example.footballmanagerdn.models.DTO.CoachDTO;
import org.example.footballmanagerdn.models.DTO.CoachWithUserDTO;
import org.example.footballmanagerdn.models.Player;
import org.example.footballmanagerdn.models.User;
import org.example.footballmanagerdn.repositories.ICoachRepo;
import org.example.footballmanagerdn.services.ICoachService;
import org.example.footballmanagerdn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CoachService implements ICoachService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ICoachRepo coachRepo;
    @Autowired
    private IUserService userService;

    @Override
    public Page<CoachDTO> findAll(int page, int size, String name, String homeTown) {
        Pageable pageable = PageRequest.of(page,size);
        return coachRepo.findAll(pageable,name,homeTown);
    }

    @Override
    public Page<Coach> findAllCoach(Pageable pageable) {
        return coachRepo.findAll(pageable);
    }


    @Override
    public Coach findById(Long id) {
        return coachRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        coachRepo.deleteById(id);
    }

    public void createCoach(CoachWithUserDTO coachDTO) {
        User user = new User();
        user.setEmail(coachDTO.getEmail());
        user.setPassword(passwordEncoder.encode(coachDTO.getPassword()));
        userService.save(user);
        Coach coach = new Coach();
        coach.setId(coachDTO.getId());
        coach.setName(coachDTO.getName());
        coach.setDob(coachDTO.getDob());
        coach.setSalary(coachDTO.getSalary());
        coach.setHomeTown(coachDTO.getHomeTown());
        coach.setAbilityProfile(coachDTO.getAbilityProfile());
        coach.setUser(user);
        coachRepo.save(coach);
    }

    @Override
    public void save(Coach coach) {
        coachRepo.save(coach);
    }

    @Override
    public Iterable<Coach> findAllByNameContaining(String search) {
        return coachRepo.findAllByNameContaining(search);
    }

}
