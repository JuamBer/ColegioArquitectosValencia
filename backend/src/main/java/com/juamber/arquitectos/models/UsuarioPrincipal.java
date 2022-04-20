package com.juamber.arquitectos.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails{

	private String nombre;
	
	private String password;
	
	private String email;
	
	private Rol rol;
	
	private Collection<? extends GrantedAuthority> authorities;

	
	public UsuarioPrincipal(String nombre, String password, String email, Rol rol,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.rol = rol;
		this.authorities = authorities;
	}
	
	public static UsuarioPrincipal build(Usuario usuario) {
		
		List<GrantedAuthority> rolAuthorities = usuario.getRol().getPermisos().stream().map(permiso -> 
		new SimpleGrantedAuthority(permiso.getNombre().name())).collect(Collectors.toList());
		
		List<GrantedAuthority> userAuthorities = usuario.getPermisos().stream().map(permiso -> 
		new SimpleGrantedAuthority(permiso.getNombre().name())).collect(Collectors.toList());
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.addAll(rolAuthorities);
		authorities.addAll(userAuthorities);
		
		return new UsuarioPrincipal(usuario.getNombre(), usuario.getPassword(), usuario.getEmail(), usuario.getRol(), authorities);
	
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
