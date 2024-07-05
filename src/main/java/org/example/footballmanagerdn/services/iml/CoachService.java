package org.example.footballmanagerdn.services.iml;



import org.example.footballmanagerdn.models.Coach;
import org.example.footballmanagerdn.repositories.ICoachRepo;
import org.example.footballmanagerdn.services.ICoachService;
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

    @Override
    public Coach findById(Long id) {
       return coachRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        coachRepo.deleteById(id);
    }

    @Override
    public void save(Coach coach) {
        coachRepo.save(coach);
    }

    @Override
    public Iterable<Coach> findAllByNameContaining(String search) {
        return coachRepo.findAllByNameContaining(search);
    }

}
