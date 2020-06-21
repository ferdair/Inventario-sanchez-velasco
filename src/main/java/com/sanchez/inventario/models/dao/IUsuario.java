package com.sanchez.inventario.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sanchez.inventario.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{

}
