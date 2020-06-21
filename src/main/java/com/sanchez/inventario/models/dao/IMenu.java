package com.sanchez.inventario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.Menu;

public interface IMenu extends CrudRepository<Menu	, Integer>{

}
