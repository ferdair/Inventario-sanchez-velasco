package com.sanchez.inventario.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.ConsumoMenu;

public interface IConsumoMenu extends CrudRepository<ConsumoMenu, Integer> {
	public List<ConsumoMenu> findByConsumoid(Integer consumoid);
}
