package com.sanchez.inventario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.Proveedor;

public interface IProveedor extends CrudRepository<Proveedor, Integer>{

}
