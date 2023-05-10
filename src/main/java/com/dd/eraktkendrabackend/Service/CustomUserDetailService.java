package com.dd.eraktkendrabackend.Service;

import com.dd.eraktkendrabackend.Entity.FieldWorker;
import com.dd.eraktkendrabackend.Repository.FieldWorkerRepository;
import com.dd.eraktkendrabackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FieldWorkerRepository fieldWorkerRepository;

    private Set getAuthorityCustomer(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    private Set getAuthorityFieldWorker(){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_FIELDWORKER"));
        return authorities;
    }
    @Override
    public UserDetails loadUserByUsername(String userName){
        // Check if user is a fieldWorker
        FieldWorker fieldWorker = fieldWorkerRepository.findByEmailId(userName);
        if (fieldWorker != null) {
            return new User(fieldWorker.getEmailId(), fieldWorker.getPassword(), getAuthorityFieldWorker());
        }

        // Check if user is a user
        com.dd.eraktkendrabackend.Entity.User user = userRepository.findByEmailId(userName);
        if (user != null) {
            return new User(user.getEmailId(), user.getPassword(), getAuthorityCustomer());
        }

        throw new UsernameNotFoundException("User Not Found");
    }
}
