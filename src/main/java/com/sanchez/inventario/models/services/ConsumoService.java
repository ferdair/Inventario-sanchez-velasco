package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IConsumo;
import com.sanchez.inventario.models.entities.Consumo;


@Service
public class ConsumoService implements IConsumoService{
	
	@Autowired //Inyección de dependencia
	private IConsumo dao;
		
	@Override
	@Transactional
	public void save(Consumo c) {
		dao.save(c);		
	}

	@Override
	@Transactional
	public Consumo findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);				
	}

	@Override
	@Transactional
	public List<Consumo> findAll() {		
		return (List<Consumo>) dao.findAll();
	}

}
