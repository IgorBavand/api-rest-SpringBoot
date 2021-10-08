package com.usuarios.apirest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
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

import com.usuarios.apirest.models.Usuario;
import com.usuarios.apirest.repository.UsuarioRepository;
import com.usuarios.apirest.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
@CrossOrigin(origins="*")
public class UsuarioController {

	@Autowired
	UsuarioService service;
	

	@PostMapping("/create")
	public Usuario salvar(@RequestBody Usuario usuario) {
		return service.save(usuario);
	}
	
	@PutMapping("/edit/{id}")
	public Usuario atualizaUsuario(@RequestBody Usuario usuario, @PathVariable(value="id") long id) {
		
		return service.updateUser(id, usuario);
		
	}
	
	
	@GetMapping("/")
	public List<Usuario> listaUsuarios(){
		return service.findAll();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deletaUsuario(@PathVariable(value="id") long id) {
		service.deleteUser(id);
	}
	
	
	
	/*
	
	@GetMapping("/{id}")
	public Usuario listaUsuarioUnico(@PathVariable(value="id") long id) {
		return usuarioRepository.findById(id);
	}
	

	
	
	@DeleteMapping("/{id}")
	public void deletaUsuario(@PathVariable(value="id") long id) {
		usuarioRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Usuario atualizaUsuario(@RequestBody Usuario usuario, @PathVariable(value="id") long id) {
		usuario.setId(id);
		return usuarioRepository.save(usuario);
		
	}
	
	@GetMapping("busca/{nome}")
	public Optional<Usuario> buscaUnuario(@PathVariable(value="nome") String nome) {
		return usuarioRepository.findByNome(nome);
	}
	*/
	
	
}
