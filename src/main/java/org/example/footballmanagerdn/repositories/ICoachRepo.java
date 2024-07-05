package org.example.footballmanagerdn.repositories;

import org.example.fooballmanagerdn.models.Coach;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoachRepo extends JpaRepository<Coach,Long> {
    Iterable<Coach> findAllByNameContaining(String search);


}
