package com.nihilo.Diamond.service;

import com.nihilo.Diamond.model.Administrator;
import com.nihilo.Diamond.repository.AdministratorRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
//implemented the user details in this class
public class AdministratorServiceImpl implements AdministratorService, UserDetailsService {
    private final AdministratorRepo administratorRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepo.findByUsername(username);
        if(administrator ==null){
            log.error("user not found");
            throw new UsernameNotFoundException("User not found in database");
        }else{
            log.info("User found in the db");
        }
        return new User(administrator.getUsername(), administrator.getPassword(),new ArrayList<>());
    }


    @Override
    public Administrator saveAdministrator(Administrator administrator) {
        log.info("saving the student");
        administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
        return administratorRepo.save(administrator);
    }

    @Override
    public Administrator getAdministrator(String username) {
        return administratorRepo.findByUsername(username);
    }

    @Override
    public List<Administrator> getAdministrators() {
        return administratorRepo.findAll();
    }


}
