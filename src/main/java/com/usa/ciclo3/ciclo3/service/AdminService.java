package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Admin;
import com.usa.ciclo3.ciclo3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin){
        if(admin.getIdAdmin()==null){
            return adminRepository.save(admin);
        }
        else{
            Optional<Admin> adminAux=adminRepository.getAdmin(admin.getIdAdmin());
            if(adminAux.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }
    }
}
