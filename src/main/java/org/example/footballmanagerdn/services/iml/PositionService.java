package org.example.footballmanagerdn.services.iml;

import org.example.footballmanagerdn.models.Position;
import org.example.footballmanagerdn.repositories.IPositionRepo;
import org.example.footballmanagerdn.services.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepo positionRepo;

    @Override
    public Iterable<Position> findAllPosition() {
        return positionRepo.findAll();
    }
}
