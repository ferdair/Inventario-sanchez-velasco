package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IRol;
import com.sanchez.inventario.models.entities.Rol;

@Service
public class RolService implements IRolService{
	private IRol dao;

	@Override
	@Transactional
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Rol>) dao.findAll();
	}

}
