package org.example.fooballmanagerdn.repositories;

import org.example.fooballmanagerdn.models.Coach;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoachRepo extends CrudRepository<Coach,Long> {
    Iterable<Coach> findAllByNameContaining(String search);
}
