package com.sanchez.inventario.models.services;

import java.util.List;

import com.sanchez.inventario.models.entities.MenuProducto;

public interface IMenuProductoService {

	public void save(MenuProducto c);
	public MenuProducto findById(Integer id);
	public void delete(Integer id);
	public List<MenuProducto> findAll();
}
