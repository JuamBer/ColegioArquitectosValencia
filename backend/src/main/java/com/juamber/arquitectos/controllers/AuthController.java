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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.juamber.arquitectos.dto.JwtDTO;
import com.juamber.arquitectos.dto.LoginUsuarioDTO;
import com.juamber.arquitectos.dto.RegistroUsuarioDTO;
import com.juamber.arquitectos.enums.NombresPermisos;
import com.juamber.arquitectos.enums.NombresRoles;
import com.juamber.arquitectos.models.Permiso;
import com.juamber.arquitectos.models.Rol;
import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.repositorys.UsuarioRepository;
import com.juamber.arquitectos.security.JwtProvider;
import com.juamber.arquitectos.services.PermisoService;
import com.juamber.arquitectos.services.RolService;
import com.juamber.arquitectos.services.UsuarioService;



@RequestMapping("/auth")
@RestController
@CrossOrigin
public class AuthController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PermisoService permisoService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegistroUsuarioDTO nuevoUsuario, BindingResult bindingResult){
		System.out.println("register()\n"+nuevoUsuario);
		if(bindingResult.hasErrors()) {
			return new ResponseEntity("Campos incorrectos", HttpStatus.BAD_REQUEST);
		}
		if(usuarioService.existsByNombre(nuevoUsuario.getNombre())) {
			return new ResponseEntity("El nombre ya existe", HttpStatus.BAD_REQUEST);
		}
		
		Optional<Rol> rol = rolService.findByNombre(nuevoUsuario.getRol().getNombre());
		
		if(rol.isPresent()) {
			Usuario usuario = new Usuario(
					nuevoUsuario.getNombre(),
					passwordEncoder.encode(nuevoUsuario.getPassword()),
					nuevoUsuario.getEmail(),
					rol.get());
			
			usuarioService.save(usuario);
			return new ResponseEntity(usuario, HttpStatus.CREATED);
		}else {
			return new ResponseEntity("El Rol no xiste", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginUsuarioDTO loginUsuario, BindingResult bindingResult){
		System.out.println("login()\n"+loginUsuario);
		if(bindingResult.hasErrors()) {
			return new ResponseEntity("Campos incorrectos", HttpStatus.BAD_REQUEST);
		}
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getNombre(),loginUsuario.getPassword())
		);
		Optional<Usuario> usuarioOpt = usuarioService.findByNombre(loginUsuario.getNombre());
		Usuario usuario = usuarioOpt.get();
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails)(authentication.getPrincipal());
		JwtDTO jwtDto = new JwtDTO(usuario.getId(),jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
	
	@PostMapping("/getUserSesion")
	public ResponseEntity<?> getUserSesion(@RequestParam String token, BindingResult bindingResult){
		System.out.println("getUserSesion()\ntoken: "+token);
		if(bindingResult.hasErrors()) {
			return new ResponseEntity("Campos incorrectos", HttpStatus.BAD_REQUEST);
		}

		
		return new ResponseEntity(null, HttpStatus.OK);
	}
}
