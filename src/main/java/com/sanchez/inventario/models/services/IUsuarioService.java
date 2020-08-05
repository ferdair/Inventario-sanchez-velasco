package com.sanchez.inventario.models.services;

import java.util.List;


import com.sanchez.inventario.models.entities.Usuario;

public interface IUsuarioService {

	public void save(Usuario c);
	public Usuario findById(Integer id);
	public void delete(Integer id);
	public List<Usuario> findAll();
}
