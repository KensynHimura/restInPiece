package com.restinpeace.service;

import com.restinpeace.entities.Role;
import com.restinpeace.repository.RoleRepository;

import java.util.Collection;
import java.util.Set;

public interface RoleService {
    Set<Role> allRoles();
}
