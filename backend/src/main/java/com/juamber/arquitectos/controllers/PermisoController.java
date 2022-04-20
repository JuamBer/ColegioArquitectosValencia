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
import com.juamber.arquitectos.models.Permiso;
import com.juamber.arquitectos.models.Rol;
import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.repositorys.UsuarioRepository;
import com.juamber.arquitectos.security.JwtProvider;
import com.juamber.arquitectos.services.EventoService;
import com.juamber.arquitectos.services.PermisoService;

import java.util.Optional;

@RequestMapping("/permisos")
@RestController
@CrossOrigin
public class PermisoController {

	@Autowired
	private PermisoService permisoService;
	
	@PreAuthorize("hasAuthority('LISTAR_EVENTOS')")
	@GetMapping("/lista")
	public ResponseEntity<List<Permiso>> list() {
		System.out.println("permisos list()");
		List<Permiso> list = permisoService.list();
		System.out.println(list);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
}
