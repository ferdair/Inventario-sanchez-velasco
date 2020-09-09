package com.sanchez.inventario.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "menu", fetch=FetchType.LAZY)
	private List<MenuProducto> productos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "menu", fetch=FetchType.LAZY)
	private List<ConsumoMenu> consumos;

	public Menu() {
		super();
	}

	public Menu(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	



	public List<MenuProducto> getProductos() {
		if (productos==null)
			productos= new ArrayList<MenuProducto>();
		return productos;
	}

	public void setProductos(List<MenuProducto> productos) {
		this.productos = productos;
	}

	public List<ConsumoMenu> getConsumos() {
		if (consumos==null)
			consumos=new ArrayList<ConsumoMenu>();
		return consumos;
	}

	public void setConsumos(List<ConsumoMenu> consumos) {
		this.consumos = consumos;
	}

	@Override
	public String toString() {
		return this.getNombre()+"";
	}

}
