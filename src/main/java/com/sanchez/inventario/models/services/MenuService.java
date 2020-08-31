package com.sanchez.inventario.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanchez.inventario.models.dao.IMenu;
import com.sanchez.inventario.models.dao.IMenuProducto;
import com.sanchez.inventario.models.entities.Menu;
import com.sanchez.inventario.models.entities.MenuProducto;

@Service
public class MenuService implements IMenuService {

	@Autowired // Inyección de dependencia
	private IMenu dao;

	@Autowired // Inyección de dependencia
	private IMenuProducto daoMenuProducto;

	@Override
	@Transactional
	public void save(Menu c) {
		try {
			dao.save(c);
			for (MenuProducto mp : c.getProductos()) {
				mp.setMenu(c);
				daoMenuProducto.save(mp);

			}
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	@Transactional
	public Menu findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Menu> findAll() {
		return (List<Menu>) dao.findAll();
	}

	@Override
	public List<Menu> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return dao.findByNombreStartingWith(nombre);
	}

}
