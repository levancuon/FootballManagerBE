package org.example.fooballmanagerdn.services.iml;

import org.example.fooballmanagerdn.models.Coach;
import org.example.fooballmanagerdn.repositories.ICoachRepo;
import org.example.fooballmanagerdn.services.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachService implements ICoachService {
    @Autowired
    private ICoachRepo coachRepo;
    @Override
    public Page<Coach> findAllCoach(Pageable pageable) {
        return coachRepo.findAll(pageable);
    }
}
