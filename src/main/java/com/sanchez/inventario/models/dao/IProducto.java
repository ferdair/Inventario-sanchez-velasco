package com.sanchez.inventario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.Producto;

public interface IProducto extends CrudRepository<Producto, Integer>{

}
