package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Admin;
import com.usa.ciclo3.ciclo3.model.Skateboard;
import com.usa.ciclo3.ciclo3.repository.crud.AdminCrudRepository;
import com.usa.ciclo3.ciclo3.repository.crud.SkateboardCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
}