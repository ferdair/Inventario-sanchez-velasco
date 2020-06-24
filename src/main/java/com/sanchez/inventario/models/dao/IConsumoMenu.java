package com.sanchez.inventario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.ConsumoMenu;

public interface IConsumoMenu extends CrudRepository<ConsumoMenu, Integer> {

}
