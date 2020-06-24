package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IMenuProducto;
import com.sanchez.inventario.models.entities.MenuProducto;

@Service
public class MenuProductoService implements IMenuProductoService {

	@Autowired //Inyección de dependencia
	private IMenuProducto dao;
		
	
	
	@Override
	@Transactional
	public void save(MenuProducto c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public MenuProducto findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<MenuProducto> findAll() {		
		return (List<MenuProducto>) dao.findAll();
	}


	
}
