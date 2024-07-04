package org.example.fooballmanagerdn.repositories;

import org.example.fooballmanagerdn.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepo extends PagingAndSortingRepository<User,Long> {
}
