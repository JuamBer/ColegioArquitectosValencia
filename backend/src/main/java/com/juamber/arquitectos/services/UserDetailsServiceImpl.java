package com.juamber.arquitectos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.models.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UsuarioService service;
	
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario usuario = service.findByNombre(nombre).get();
		return UsuarioPrincipal.build(usuario);
	}

}
