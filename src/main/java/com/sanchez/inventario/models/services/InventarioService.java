package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IInventario;
import com.sanchez.inventario.models.entities.Inventario;

@Service

public class InventarioService implements IInventarioService{

	@Autowired //Inyección de dependencia
	private IInventario dao;
		
	@Override
	@Transactional
	public void save(Inventario c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public Inventario findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Inventario> findAll() {		
		return (List<Inventario>) dao.findAll();
	}

}
