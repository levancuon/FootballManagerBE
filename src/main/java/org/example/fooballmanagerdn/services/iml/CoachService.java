package org.example.fooballmanagerdn.services.iml;

import org.example.fooballmanagerdn.models.Coach;
import org.example.fooballmanagerdn.repositories.ICoachRepo;
import org.example.fooballmanagerdn.services.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoachService implements ICoachService {
    @Autowired
    private ICoachRepo coachRepo;
    @Override
    public Iterable<Coach> findAllCoach() {
        return coachRepo.findAll();
    }
}
