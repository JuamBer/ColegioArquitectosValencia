package com.juamber.arquitectos.util;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.juamber.arquitectos.enums.NombresPermisos;
import com.juamber.arquitectos.enums.NombresRoles;
import com.juamber.arquitectos.models.Evento;
import com.juamber.arquitectos.models.Permiso;
import com.juamber.arquitectos.models.Rol;
import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.services.EventoService;
import com.juamber.arquitectos.services.PermisoService;
import com.juamber.arquitectos.services.RolService;
import com.juamber.arquitectos.services.UsuarioService;

@Component
public class DefaultData implements CommandLineRunner {
	
	@Autowired 
	PermisoService permisoService;
	@Autowired 
	RolService rolService;
	@Autowired 
	UsuarioService usuarioService;
	@Autowired 
	EventoService eventoService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		//Permsisos
		Permiso listar_usuarios = new Permiso(NombresPermisos.LISTAR_USUARIOS);
		Permiso editar_usuario = new Permiso(NombresPermisos.EDITAR_USUARIO);
		Permiso eliminar_usuario = new Permiso(NombresPermisos.ELIMINAR_USUARIO);
		Permiso listar_eventos = new Permiso(NombresPermisos.LISTAR_EVENTOS);
		Permiso crear_eventos = new Permiso(NombresPermisos.CREAR_EVENTO);
		Permiso editar_evento = new Permiso(NombresPermisos.EDITAR_EVENTO);
		Permiso eliminar_eventos = new Permiso(NombresPermisos.ELIMINAR_EVENTO);
		
		Set<Permiso> permisosRolAdmin = new HashSet<>();
		permisosRolAdmin.add(listar_usuarios);
		permisosRolAdmin.add(editar_usuario);
		permisosRolAdmin.add(eliminar_usuario);
		permisosRolAdmin.add(listar_eventos);
		permisosRolAdmin.add(crear_eventos);
		permisosRolAdmin.add(editar_evento);
		permisosRolAdmin.add(eliminar_eventos);

		Set<Permiso> permisosRolUser = new HashSet<>();
		permisosRolUser.add(listar_eventos);
		
		permisoService.save(listar_usuarios);
		permisoService.save(editar_usuario);
		permisoService.save(eliminar_usuario);
		permisoService.save(listar_eventos);
		permisoService.save(crear_eventos);
		permisoService.save(editar_evento);
		permisoService.save(eliminar_eventos);
		
		//Roles
		Rol rolAdmin = new Rol(NombresRoles.ROLE_ADMIN, permisosRolAdmin);
		Rol rolUser = new Rol(NombresRoles.ROLE_USER, permisosRolUser);
		
		rolService.save(rolAdmin);
		rolService.save(rolUser);
		
		//Usuarios
		Set<Permiso> permisosEspecialesRaul = new HashSet<>();
		Set<Permiso> permisosEspecialesAna = new HashSet<>();
		permisosEspecialesRaul.add(listar_usuarios);
		permisosEspecialesAna.add(eliminar_eventos);
		
		permisosRolUser.add(listar_eventos);
		Usuario admin = new Usuario("admin",passwordEncoder.encode("admin"),"admin@email.com",rolAdmin);
		Usuario user = new Usuario("user",passwordEncoder.encode("user"),"user@email.com",rolUser,permisosEspecialesRaul);
		Usuario juan = new Usuario("juan",passwordEncoder.encode("juan"),"juan@email.com",rolAdmin);
		Usuario raul = new Usuario("raul",passwordEncoder.encode("raul"),"raul@email.com",rolUser);
		Usuario ivan = new Usuario("ivan",passwordEncoder.encode("ivan"),"ivan@email.com",rolUser);
		Usuario ana = new Usuario("ana",passwordEncoder.encode("ana"),"ana@email.com",rolUser,permisosEspecialesAna);
		
		usuarioService.save(admin);
		usuarioService.save(user);
		usuarioService.save(juan);
		usuarioService.save(raul);
		usuarioService.save(ivan);
		usuarioService.save(ana);
		
		//EVENTOS
		Date today = new Date(2022,04,20);
		Evento evento1 = new Evento("Evento1",today,"Lorem Ipsum","evento1.com");
		Evento evento2 = new Evento("Evento2",today,"Lorem Ipsum","evento2.com");
		Evento evento3 = new Evento("Evento3",today,"Lorem Ipsum","evento3.com");
		Evento evento4 = new Evento("Evento4",today,"Lorem Ipsum","evento4.com");
		
		eventoService.save(evento1);
		eventoService.save(evento2);
		eventoService.save(evento3);
		eventoService.save(evento4);*/
	}

}
