package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IMenu;
import com.sanchez.inventario.models.entities.Menu;

@Service
public class MenuService implements IMenuService{


	@Autowired //Inyección de dependencia
	private IMenu dao;
		
	@Override
	@Transactional
	public void save(Menu c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public Menu findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Menu> findAll() {		
		return (List<Menu>) dao.findAll();
	}


}
