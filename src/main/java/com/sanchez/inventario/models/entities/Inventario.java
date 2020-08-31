package com.sanchez.inventario.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  
@Table(name="inventarios")
public class Inventario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_inventario")	
	private Long id;
	@Column(name="cantidad")	
	private int cantidad;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "fk_producto") private Producto producto;
	 * 
	 */
	public Inventario() {
		super();
	}
	public Inventario(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/*	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	*/
	
	
	

}
