package com.juamber.arquitectos.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.juamber.arquitectos.repositorys.TokenRepository;
import com.juamber.arquitectos.models.Token;
import com.juamber.arquitectos.models.Usuario;


@Service
public class TokenService {
	
	@Autowired
	private TokenRepository repository;
	
	public Optional<Token> findByToken(String token){
		return repository.findByToken(token);
	}

    public void save(Token token){
    	repository.save(token);
    }
    
    public void delete(int id){
    	repository.deleteById(id);
    }
    
    public void deleteAllTokens(int id){
    	repository.deleteAllTokens(id);
    }


}
