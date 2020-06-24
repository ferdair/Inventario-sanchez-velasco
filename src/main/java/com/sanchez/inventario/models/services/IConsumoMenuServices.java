package com.sanchez.inventario.models.services;

import java.util.List;
import com.sanchez.inventario.models.entities.ConsumoMenu;

public interface IConsumoMenuServices {


	public void save(ConsumoMenu c);
	public ConsumoMenu findById(Integer id);
	public void delete(Integer id);
	public List<ConsumoMenu> findAll();

}
