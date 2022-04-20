package com.juamber.arquitectos.repositorys;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juamber.arquitectos.enums.NombresRoles;
import com.juamber.arquitectos.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByNombre(NombresRoles nombre);
}
