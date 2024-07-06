package org.example.footballmanagerdn.repositories;

import org.example.footballmanagerdn.models.Position;
import org.springframework.data.repository.CrudRepository;

public interface IPositionRepo extends CrudRepository<Position, Long> {
}
