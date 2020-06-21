package com.sanchez.inventario.models.services;

import java.util.List;

import com.sanchez.inventario.models.entities.Producto;

public interface IProductoService {

	public void save(Producto c);
	public Producto findById(Integer id);
	public void delete(Integer id);
	public List<Producto> findAll();
}
