package org.example.footballmanagerdn.services;


import org.example.footballmanagerdn.models.Coach;

public interface ICoachService {
    Iterable<Coach> findAllCoach();

    Coach findById(Long id);

    void remove(Long id);

    void save(Coach coach);

    Iterable<Coach> findAllByNameContaining(String search);
}
