package com.restinpeace.repository;

import com.restinpeace.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
}
