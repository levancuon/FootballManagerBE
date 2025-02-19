package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface IUserRepo extends PagingAndSortingRepository<User,Long>, CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
