package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IProveedor;
import com.sanchez.inventario.models.entities.Proveedor;

@Service
public class ProveedorService implements IProveedorService{
	
	@Autowired //Inyección de dependencia
	private IProveedor dao;
		
	@Override
	@Transactional
	public void save(Proveedor c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public Proveedor findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Proveedor> findAll() {		
		return (List<Proveedor>) dao.findAll();
	}




}
