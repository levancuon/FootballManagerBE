package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoachRepo extends JpaRepository<Coach,Long> {
    Iterable<Coach> findAllByNameContaining(String search);


}
