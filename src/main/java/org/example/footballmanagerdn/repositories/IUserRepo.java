package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepo extends PagingAndSortingRepository<User,Long>, CrudRepository<User,Long> {
}
