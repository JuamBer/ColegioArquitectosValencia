package com.juamber.arquitectos.repositorys;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juamber.arquitectos.models.Token;
import com.juamber.arquitectos.models.Usuario;


@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>{
	Optional<Token> findByToken(String token);
	Optional<Token> findById(int id);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Token WHERE usuario_id = ?1")
    public void deleteAllTokens(int id);
}
