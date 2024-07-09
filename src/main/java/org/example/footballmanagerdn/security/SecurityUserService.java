package org.example.footballmanagerdn.security;

import org.example.footballmanagerdn.models.User;
import org.example.footballmanagerdn.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserService implements UserDetailsService {
    @Autowired
    private IUserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user.get());
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }
}
