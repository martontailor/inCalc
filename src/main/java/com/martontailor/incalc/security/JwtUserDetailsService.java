package com.martontailor.incalc.security;

import com.martontailor.incalc.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.martontailor.incalc.domain.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public com.martontailor.incalc.domain.User save(com.martontailor.incalc.domain.User user) {
        com.martontailor.incalc.domain.User newUser = com.martontailor.incalc.domain.User.builder()
                .username(user.getUsername())
                .password(bcryptEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .build();
        return userRepository.save(newUser);
    }
}
