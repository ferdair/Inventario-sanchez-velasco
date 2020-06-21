package com.sanchez.inventario.models.services;

import java.util.List;

import com.sanchez.inventario.models.entities.Proveedor;

public interface IProveedorService {
	public void save(Proveedor c);
	public Proveedor findById(Integer id);
	public void delete(Integer id);
	public List<Proveedor> findAll();
}
