package org.example.fooballmanagerdn.services;

import org.example.fooballmanagerdn.models.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICoachService {
    Iterable<Coach> findAllCoach();
}
