package com.juamber.arquitectos.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import com.juamber.arquitectos.models.Permiso;
import com.juamber.arquitectos.models.Rol;
import com.juamber.arquitectos.models.Usuario;
import com.juamber.arquitectos.repositorys.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> findById(int id){
        return repository.findById(id);
    }
	
	public Optional<Usuario> findByNombre(String nombre){
		return repository.findByNombre(nombre);
	}
	
	public Optional<Usuario> findByEmail(String email){
		return repository.findByEmail(email);
	}
	
	public Optional<Usuario> findByNombreOrEmail(String nombreOrEmail){
		return repository.findByNombreOrEmail(nombreOrEmail,nombreOrEmail);
	}
	
	public boolean existsByNombre(String nombre){
		return repository.existsByNombre(nombre);
	}
	
	public List<Usuario> list(){
        return repository.findAll();
    }

    public Optional<Usuario> getOne(int id){
        return repository.findById(id);
    }

    public void delete(int id){
    	repository.deleteById(id);
    }

    public boolean existsById(int id){
        return repository.existsById(id);
    }
    
	public void save(Usuario usuario) {
		repository.save(usuario);
	}
	
	public boolean checkPermiso(Permiso permiso, int id) {
		Optional<Usuario> usuarioOpt = repository.findById(id);
		Usuario usuario = usuarioOpt.get();
		if(usuario.getId() == id) {
			boolean tienePermiso = false;
			
			for (Permiso permisoactual : usuario.getPermisos()) {
				if(permisoactual.getId() == permiso.getId()) {
					tienePermiso = true;
					return tienePermiso;
				}
			}
			
			for (Permiso permisoactual : usuario.getRol().getPermisos()) {
				if(permisoactual.getId() == permiso.getId()) {
					tienePermiso = true;
					return tienePermiso;
				}		
			}
			

			return tienePermiso;
		}
		
		return false;
	}
	public Usuario updateUsuario(Usuario usuario) {
		Optional<Usuario> usuarioOpt = repository.findById(usuario.getId());
		Usuario result = usuarioOpt.get();
		if(usuario.getId() == result.getId()) {
			result.setNombre(usuario.getNombre());
			result.setEmail(usuario.getEmail());
			result.setRol(usuario.getRol());
			result.setPermisos(usuario.getPermisos());
			
			save(result);
			return result;
		}
		return null;
	} 
	
	public boolean checkRolPermiso(Permiso permiso, int id) {
		Optional<Usuario> usuarioOpt = repository.findById(id);
		Usuario usuario = usuarioOpt.get();
		if(usuario.getId() == id) {
			boolean tienePermiso = false;
			
			for (Permiso permisoactual : usuario.getRol().getPermisos()) {
				if(permisoactual.getId() == permiso.getId()) {
					tienePermiso = true;
					return tienePermiso;
				}		
			}

			return tienePermiso;
		}
		
		return false;
	}
	
	public ArrayList<Permiso> getPermisos(Usuario usuario) {
		ArrayList<Permiso> permisos = new ArrayList<Permiso>();
		permisos.addAll(usuario.getRol().getPermisos());
		permisos.addAll(usuario.getPermisos());
		return permisos;
	}

}
