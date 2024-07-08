package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.DTO.PlayerDto;
import org.example.footballmanagerdn.models.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPlayerRepo extends PagingAndSortingRepository<Player, Long>, CrudRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE " +
            "(:name IS NULL OR p.name like %:name%) AND " +
            "(:salaryMin IS NULL OR p.salary >= :salaryMin) AND " +
            "(:salaryMax IS NULL OR p.salary <= :salaryMax) AND " +
            "(:positionId IS NULL OR p.position.id = :positionId) AND " +
            "(:status IS NULL OR :status = ''    OR p.status = :status)")
    Page<PlayerDto> findAll(
            Pageable pageable,
            @Param("name") String name,
            @Param("salaryMin") Double salaryMin,
            @Param("salaryMax") Double salaryMax,
            @Param("positionId") Long positionId,
            @Param("status") String status
    );

    Optional<PlayerDto> findPlayerById(Long id);
}
