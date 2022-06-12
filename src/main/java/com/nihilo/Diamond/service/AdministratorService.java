package com.nihilo.Diamond.service;

import com.nihilo.Diamond.model.Administrator;

import java.util.List;
//coding to interface
public interface AdministratorService {

     Administrator saveAdministrator(Administrator administrator);
     Administrator getAdministrator(String username);

     List<Administrator> getAdministrators();


}
