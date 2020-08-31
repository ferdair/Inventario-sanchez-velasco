package com.sanchez.inventario.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.Menu;

public interface IMenu extends CrudRepository<Menu	, Integer>{
	public List<Menu> findByNombreStartingWith(String nombre);

}
