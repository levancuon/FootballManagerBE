package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.Coach;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ICoachRepo extends PagingAndSortingRepository<Coach,Long> , CrudRepository<Coach,Long> {

    Iterable<Coach> findAllByNameContaining(String search);


}
