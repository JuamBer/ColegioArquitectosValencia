package com.juamber.arquitectos.repositorys;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juamber.arquitectos.enums.NombresRoles;
import com.juamber.arquitectos.models.Evento;
import com.juamber.arquitectos.models.Rol;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{
	Optional<Evento> findByNombre(String nombre);
	Optional<Evento> findById(int id);
    boolean existsByNombre(String nombre);
}
