package com.juamber.arquitectos.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juamber.arquitectos.dto.JwtDTO;
import com.juamber.arquitectos.dto.LoginUsuarioDTO;
import com.juamber.arquitectos.dto.RegistroUsuarioDTO;
import com.juamber.arquitectos.enums.NombresRoles;
import com.juamber.arquitectos.models.Evento;
import com.juamber.arquitectos.models.Rol;
import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.repositorys.UsuarioRepository;
import com.juamber.arquitectos.security.JwtProvider;
import com.juamber.arquitectos.services.EventoService;
import com.juamber.arquitectos.services.RolService;
import com.juamber.arquitectos.services.UsuarioService;

import java.util.Optional;

@RequestMapping("/eventos")
@RestController
@CrossOrigin
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@PreAuthorize("hasAuthority('LISTAR_EVENTOS')")
	@GetMapping("/lista")
	public ResponseEntity<List<Evento>> list() {
		System.out.println("list()");
		List<Evento> list = eventoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('LISTAR_EVENTOS')")
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		System.out.println("getById()\nId:"+id);
		if (!eventoService.existsById(id))
			return new ResponseEntity("No existe ningún Evento con ese Id", HttpStatus.NOT_FOUND);
		Evento evento = eventoService.getOne(id).get();
		return new ResponseEntity(evento, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('CREAR_EVENTO')")
	@PostMapping("/nuevo")
	public ResponseEntity<?> create(@Valid @RequestBody Evento evento, BindingResult bindingResult) {
		System.out.println("create()\n"+evento);
		if (bindingResult.hasErrors()) {
			return new ResponseEntity("Campos incorrectos", HttpStatus.BAD_REQUEST);
		}

		eventoService.save(evento);
		return new ResponseEntity(evento, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('ELIMINAR_EVENTO')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
		System.out.println("delete()\nId:"+id);
        if(!eventoService.existsById(id)) {
            return new ResponseEntity("No existe ningún Evento con ese Id", HttpStatus.NOT_FOUND);
        }
        Optional<Evento> eventoOpt = eventoService.findById(id);
        Evento evento = eventoOpt.get();
        eventoService.delete(id);
        return new ResponseEntity(evento, HttpStatus.OK);
    }
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEvento(@RequestBody Evento evento) {
		System.out.println("updateEvento()");
		System.out.println(evento);
		
		Evento res = eventoService.updateEvento(evento);
		return new ResponseEntity(res, HttpStatus.OK);
	}

}
