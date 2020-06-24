package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanchez.inventario.models.dao.IConsumoMenu;
import com.sanchez.inventario.models.entities.ConsumoMenu;

@Service
public class ConsumoMenuService implements IConsumoMenuServices {

	@Autowired //Inyección de dependencia
	private IConsumoMenu dao;
	
	@Override
	public void save(ConsumoMenu c) {
		dao.save(c);		
			
	}

	@Override
	public ConsumoMenu findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);				
	
	}

	@Override
	public List<ConsumoMenu> findAll() {
		return (List<ConsumoMenu>) dao.findAll();
		
	}

	
}
