package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.DTO.PlayerDto;
import org.example.footballmanagerdn.models.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IPlayerRepo extends PagingAndSortingRepository<Player, Long>, CrudRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE " +
            "(:name IS NULL OR p.name like %:name%) AND " +
            "(:salaryMin IS NULL OR p.salary >= :salaryMin) AND " +
            "(:salaryMax IS NULL OR p.salary <= :salaryMax) AND " +
            "(:position IS NULL OR p.position = :position) AND " +
            "(:status IS NULL OR p.status = :status)")
    Page<PlayerDto> findAll(
            Pageable pageable,
            @Param("name") String name,
            @Param("salaryMin") Double salaryMin,
            @Param("salaryMax") Double salaryMax,
            @Param("position") String position,
            @Param("status") String status
    );
}
