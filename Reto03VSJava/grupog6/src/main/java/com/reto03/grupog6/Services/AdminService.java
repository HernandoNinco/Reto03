package com.reto03.grupog6.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto03.grupog6.Entities.Admin;
import com.reto03.grupog6.Repository.AdminRepsoitory;

@Service
public class AdminService {
    @Autowired
    private AdminRepsoitory adminRepository;

    public Admin addAdmin(Admin admin) {
        Boolean bGrabar = true;

        if (admin.getName() == null)
            bGrabar = false;

        if (admin.getPassword() == null)
            bGrabar = false;

        if (admin.getEmail() == null)
            bGrabar = false;

        if (bGrabar == true)
            return adminRepository.addAdmin(admin);
        else
            return admin;

    }


    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.getAll();
    }

    public Admin updAdmin(Admin admin) {
        return adminRepository.updAdmin(admin);
    }

    public Admin getAdmin(Integer id) {
        return adminRepository.getAdmin(id);
    }

    public void delAdmin(Integer id) {
        adminRepository.delAdmin(id);
    }
    
}