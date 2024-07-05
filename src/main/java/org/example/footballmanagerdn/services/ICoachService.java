package org.example.footballmanagerdn.services;

import org.example.fooballmanagerdn.models.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICoachService {
    Iterable<Coach> findAllCoach();

    Coach findById(Long id);

    void remove(Long id);

    void save(Coach coach);

    Iterable<Coach> findAllByNameContaining(String search);
}
