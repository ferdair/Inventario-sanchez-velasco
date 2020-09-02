package com.sanchez.inventario.models.services;

import java.util.List;

import com.sanchez.inventario.models.entities.Menu;

public interface IMenuService {
	public void save(Menu c);
	public Menu findById(Integer id);
	public void delete(Integer id);
	public List<Menu> findAll();
	public List<Menu> findByNombre(String nombre);
	

}
