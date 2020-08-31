package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IProducto;
import com.sanchez.inventario.models.entities.Producto;

@Service
public class ProductoService implements IProductoService{

	@Autowired //Inyección de dependencia
	private IProducto dao;
		
	@Override
	@Transactional
	public void save(Producto c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public Producto findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Producto> findAll() {		
		return (List<Producto>) dao.findAll();
	}

	
	@Override
	@Transactional
	public List<Producto> findByNombre(String nombre) {		
		return dao.findByNombreStartingWith(nombre);
	}


}
