package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IUsuario;
import com.sanchez.inventario.models.entities.Usuario;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired //Inyección de dependencia
	private IUsuario dao;
		
	@Override
	@Transactional
	public void save(Usuario c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public Usuario findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Usuario> findAll() {		
		return (List<Usuario>) dao.findAll();
	}





}
