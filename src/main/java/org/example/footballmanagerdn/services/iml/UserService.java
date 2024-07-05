package org.example.footballmanagerdn.services.iml;

import org.example.footballmanagerdn.models.User;
import org.example.footballmanagerdn.repositories.IUserRepo;
import org.example.footballmanagerdn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;
    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
