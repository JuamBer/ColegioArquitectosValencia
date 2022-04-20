package com.juamber.arquitectos.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

import com.juamber.arquitectos.dto.ChangePasswordFormDTO;
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
import com.juamber.arquitectos.services.RolService;
import com.juamber.arquitectos.services.UsuarioService;

@RequestMapping("/usuarios")
@RestController
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PreAuthorize("hasAuthority('LISTAR_USUARIOS')")
	@GetMapping("/lista")
	public ResponseEntity<List<Usuario>> list() {
		System.out.println("list()");
		List<Usuario> list = usuarioService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('LISTAR_USUARIOS')")
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id) {
		System.out.println("getById()\nId:"+id);
		if (!usuarioService.existsById(id))
			return new ResponseEntity("No existe ningún Evento con ese Id", HttpStatus.NOT_FOUND);
		Usuario usuario = usuarioService.getOne(id).get();
		return new ResponseEntity(usuario, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ELIMINAR_USUARIO')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
		System.out.println("delete()\nId:"+id);
        if(!usuarioService.existsById(id)) {
            return new ResponseEntity("No existe ningún Evento con ese Id", HttpStatus.NOT_FOUND);
        }
        Optional<Usuario> usuarioOpt = usuarioService.findById(id);
        Usuario usuario = usuarioOpt.get();
        usuarioService.delete(id);
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
	
	@GetMapping("/permisos/{id}")
	public ResponseEntity<?> permisos(@PathVariable("id") int id) {
	System.out.println("permisos()\nId:"+id);
	if (!usuarioService.existsById(id))
		return new ResponseEntity("No existe ningún Evento con ese Id", HttpStatus.NOT_FOUND);
	Usuario usuario = usuarioService.getOne(id).get();
	
	return new ResponseEntity(this.usuarioService.getPermisos(usuario), HttpStatus.OK);
	}
	
	@PostMapping("/checkPermiso/{id_user}")
	public ResponseEntity<Boolean> checkPermiso(@PathVariable("id_user") int id_user, @RequestBody Permiso permiso) {
		System.out.println("checkPermiso()");
		
		boolean res = usuarioService.checkPermiso(permiso, id_user);
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) {
		System.out.println("updateUsuario()");
		System.out.println(usuario);
		
		Usuario res = usuarioService.updateUsuario(usuario);
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	@PostMapping("/checkRolPermiso/{id_user}")
	public ResponseEntity<Boolean> checkRolPermiso(@PathVariable("id_user") int id_user, @RequestBody Permiso permiso) {
		System.out.println("checkRolPermiso()");
		
		boolean res = usuarioService.checkRolPermiso(permiso, id_user);
		return new ResponseEntity(res, HttpStatus.OK);
	}
}
