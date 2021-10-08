package com.usuarios.apirest.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarios.apirest.models.Usuario;
import com.usuarios.apirest.repository.UsuarioRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	
	
	public Usuario getById(long id) {
		Usuario obj = repository.findById(id);
		Usuario entity = obj;
		return entity;
	}
	
	public Usuario updateUser(long id, Usuario usuario) {
		Usuario entity = getById(id);
		entity.setNome(usuario.getNome());
		entity.setCidade(usuario.getCidade());
		return repository.save(entity);
	}
	
	public void deleteUser(long id) {
		repository.deleteById(id);
	}
	
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public Usuario findById(long id) {
		return repository.findById(id);
	}
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}

}
