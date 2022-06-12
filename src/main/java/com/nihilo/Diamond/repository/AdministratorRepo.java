package com.nihilo.Diamond.repository;

import com.nihilo.Diamond.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepo extends JpaRepository<Administrator,Long> {
    Administrator findByUsername(String username);



}
