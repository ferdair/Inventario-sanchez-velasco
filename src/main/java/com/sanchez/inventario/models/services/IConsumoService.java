package com.sanchez.inventario.models.services;

import java.util.List;

import com.sanchez.inventario.models.entities.Consumo;

public interface IConsumoService {

	public void save(Consumo c);
	public Consumo findById(Integer id);
	public void delete(Integer id);
	public List<Consumo> findAll();
}
