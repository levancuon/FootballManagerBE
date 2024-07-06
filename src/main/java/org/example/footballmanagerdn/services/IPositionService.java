package org.example.footballmanagerdn.services;

import org.example.footballmanagerdn.models.Position;

public interface IPositionService {
    Iterable<Position> findAllPosition();
}
