package com.denm.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.denm.backend.modelo.entidad.Roles;

@Component
@Repository
public interface IRolesRepositorio extends JpaRepository<Roles, Integer>{

}
