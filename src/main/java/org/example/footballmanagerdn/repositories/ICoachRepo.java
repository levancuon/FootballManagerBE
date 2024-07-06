package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.Coach;

import org.example.footballmanagerdn.models.DTO.CoachDTO;
import org.example.footballmanagerdn.models.DTO.CoachWithUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;


public interface ICoachRepo extends PagingAndSortingRepository<Coach, Long>, CrudRepository<Coach, Long> {
    @Query("select p from Coach p where " +
            "(:name is null or p.name like %:name%) and" +
            "(:homeTown is null or p.homeTown like %:homeTown%) " )
    Page<CoachDTO> findAll(
            Pageable pageable,
            @Param("name") String name,
            @Param("homeTown") String homeTown
    );
    Iterable<Coach> findAllByNameContaining(String search);
}
