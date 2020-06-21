package com.sanchez.inventario.models.services;

import java.util.List;

import com.sanchez.inventario.models.entities.Inventario;

public interface IInventarioService {

	public void save(Inventario c);
	public Inventario findById(Integer id);
	public void delete(Integer id);
	public List<Inventario> findAll();
}
