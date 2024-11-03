package com.regis.Registraion_Form.config;
import com.regis.Registraion_Form.entity.User;
import com.regis.Registraion_Form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomUserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserService.class);

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("attempting to find user: " + email);
        Optional<User> userOptional = Optional.ofNullable(repo.findByEmail(email));

        if (userOptional.isEmpty()) {
            logger.warn("User not found with email: {}", email);
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new CustomUserDetails(userOptional.get());
    }
    public List<User> getAllUsers(){
        return repo.findAll();
    }

}

