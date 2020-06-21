package com.sanchez.inventario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.Consumo;

public interface IConsumo extends CrudRepository<Consumo, Integer>{

}
