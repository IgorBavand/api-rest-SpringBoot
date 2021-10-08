package com.usuarios.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usuarios.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findById(long id);
	
	List<Usuario> findByNomeContains(String nome);
	Optional<Usuario> findByNome(String nome);
	
    Long deleteById(long id);
	
	/*
	@Query("SELECT u FROM usuario WHERE nome LIKE '%?1%'")
	List<Usuario> searchByNome(String nome);
	*/
	
}
