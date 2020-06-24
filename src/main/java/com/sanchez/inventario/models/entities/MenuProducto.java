package com.sanchez.inventario.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity  
@Table(name="menu_producto")
public class MenuProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_menu_producto")	
	private Integer id;
	
	 @ManyToOne
	 @JoinColumn(name = "fk_menu")
	 private Menu menu;
	 
	 @ManyToOne
	 @JoinColumn(name = "fk_producto")
	 private Producto producto;
	 
	 @Column(name="cantidad_producto")
	 private int cantidadProducto;
	 
	 
	public MenuProducto() {
		super();
	}
	public MenuProducto(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	@Override
	public String toString() {
		return this.getMenu()+"--"+this.getProducto();
	}
	 
	
	
	 
	 
	 
	 
	
	

}
