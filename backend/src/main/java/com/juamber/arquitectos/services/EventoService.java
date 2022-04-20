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

import com.juamber.arquitectos.models.Evento;
import com.juamber.arquitectos.models.Rol;
import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.repositorys.EventoRepository;


@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repository;
	
	public List<Evento> list(){
        return repository.findAll();
    }

    public Optional<Evento> getOne(int id){
        return repository.findById(id);
    }

    public void save(Evento evento){
    	repository.save(evento);
    }

    public void delete(int id){
    	repository.deleteById(id);
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return repository.existsByNombre(nombre);
    }
    
    public Optional<Evento> findById(int id){
        return repository.findById(id);
    }
    
    public Evento updateEvento(Evento evento) {
		Optional<Evento> eventoOpt = repository.findById(evento.getId());
		Evento result = eventoOpt.get();
		if(evento.getId() == result.getId()) {
			result.setNombre(evento.getNombre());
			result.setFecha(evento.getFecha());
			result.setDescripcion(evento.getDescripcion());
			result.setWeb(evento.getWeb());
			save(result);
			return result;
		}
		return null;
	} 
}
