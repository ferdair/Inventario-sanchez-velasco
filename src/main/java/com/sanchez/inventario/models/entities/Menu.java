package com.sanchez.inventario.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity  
@Table(name="menus")
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_menu")	
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "menu")
	private Set<MenuProducto> productos;
	
	@OneToMany(mappedBy = "menu")
	private Set<ConsumoMenu> consumos;

	public Menu() {
		super();
	}

	public Menu(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	



	public Set<MenuProducto> getProductos() {
		return productos;
	}

	public void setProductos(Set<MenuProducto> productos) {
		this.productos = productos;
	}

	public Set<ConsumoMenu> getConsumos() {
		return consumos;
	}

	public void setConsumos(Set<ConsumoMenu> consumos) {
		this.consumos = consumos;
	}

	@Override
	public String toString() {
		return this.getNombre()+"";
	}

	
	


}
