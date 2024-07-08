package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.Salary;
import org.springframework.data.repository.CrudRepository;

public interface ISalaryRepo extends CrudRepository<Salary, Long> {
}
