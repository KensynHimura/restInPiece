package com.restinpeace.service;

import com.restinpeace.entities.Role;
import com.restinpeace.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> allRoles() {
        return new HashSet<>(roleRepository.findAll());
    }
}

