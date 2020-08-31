package com.sanchez.inventario.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.Producto;

public interface IProducto extends CrudRepository<Producto, Integer>{
	public List<Producto> findByNombreStartingWith(String nombre);

}
