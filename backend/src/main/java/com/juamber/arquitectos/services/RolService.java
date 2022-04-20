package com.juamber.arquitectos.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.juamber.arquitectos.enums.NombresRoles;
import com.juamber.arquitectos.models.Evento;
import com.juamber.arquitectos.models.Rol;
import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.repositorys.RolRepository;
import com.juamber.arquitectos.repositorys.UsuarioRepository;


@Service
public class RolService {
	
	@Autowired
	private RolRepository repository;
	
	public List<Rol> list(){
        return repository.findAll();
    }
	
	public Optional<Rol> findByNombre(NombresRoles nombre){
	    return repository.findByNombre(nombre);
	}
	
	public void save(Rol rol){
		repository.save(rol);
    }


}
