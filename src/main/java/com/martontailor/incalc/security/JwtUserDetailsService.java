package com.martontailor.incalc.security;

import com.martontailor.incalc.domain.Income;
import com.martontailor.incalc.domain.Outcome;
import com.martontailor.incalc.domain.Summary;
import com.martontailor.incalc.repo.SummaryRepository;
import com.martontailor.incalc.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SummaryRepository summaryRepository;

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
                .summary(getNewSummary())
                .build();
        return userRepository.save(newUser);
    }

    private Summary getNewSummary() {
        Summary summary = Summary.builder()
                .balance(0.0)
                .incomes(List.of())
                .outcomes(List.of())
                .build();

        summaryRepository.save(summary);

        return summary;
    }
}
