package com.sanchez.inventario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.MenuProducto;

public interface IMenuProducto extends CrudRepository<MenuProducto, Integer>{

}
