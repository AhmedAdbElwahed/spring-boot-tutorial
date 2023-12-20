package com.ahmed.spring_data_jpa.service;

import com.ahmed.spring_data_jpa.entity.Role;
import com.ahmed.spring_data_jpa.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role fetchRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    public List<Role> fetchRoles(Long id) {
        return roleRepository.findAll();
    }

    public Boolean deleteRoleById(Long id) {
        roleRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
