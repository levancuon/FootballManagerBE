package org.example.fooballmanagerdn.repositories;

import org.example.fooballmanagerdn.models.Coach;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public interface ICoachRepo extends PagingAndSortingRepository<Coach,Long> {

}
