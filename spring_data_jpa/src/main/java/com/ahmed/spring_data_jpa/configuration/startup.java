package com.ahmed.spring_data_jpa.configuration;

import com.ahmed.spring_data_jpa.entity.Role;
import com.ahmed.spring_data_jpa.service.RoleService;
import com.ahmed.spring_data_jpa.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class startup implements CommandLineRunner {

    private final UserService userService;

    private final RoleService roleService;


    public startup(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
