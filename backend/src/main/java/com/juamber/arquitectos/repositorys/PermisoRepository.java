package com.juamber.arquitectos.repositorys;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juamber.arquitectos.enums.NombresPermisos;
import com.juamber.arquitectos.enums.NombresRoles;
import com.juamber.arquitectos.models.Permiso;
import com.juamber.arquitectos.models.Rol;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer>{
	Optional<Permiso> findByNombre(NombresPermisos nombre);
}
