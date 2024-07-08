package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.DTO.PlayerSalaryReport;
import org.example.footballmanagerdn.models.Salary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ISalaryRepo extends CrudRepository<Salary, Long> {
    Iterable<Salary> findAllByPlayerId(Long playerId);

    @Query("SELECT sum(s.totalSalary) AS salary, s.week  AS week " +
            "FROM Salary s " +
            "WHERE s.playerId is not null " +
            "group by s.week")
    Iterable<PlayerSalaryReport> getPlayerSalaryReport();

}
