package com.nihilo.Diamond.controller;

import com.nihilo.Diamond.model.Administrator;
import com.nihilo.Diamond.repository.AdministratorRepo;
import com.nihilo.Diamond.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;



@RestController
@RequestMapping("/adminApi")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService administratorService;
    private AdministratorRepo administratorRepo;

    @GetMapping("/admins")
    public ResponseEntity<List<Administrator>>getStudents(){
        return ResponseEntity.ok().body(administratorService.getAdministrators());
    }

    @PostMapping("/admin/save")
    public ResponseEntity<?>saveStudent(@RequestBody Administrator administrator)throws URISyntaxException {
        Administrator result=administratorService.saveAdministrator(administrator);

        return ResponseEntity.created(new URI("/adminApi/admin/save"+result.getUsername())).body(result);
    }


}
