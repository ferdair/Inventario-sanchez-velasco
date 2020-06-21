package com.sanchez.inventario.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name="productos")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_producto")	
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	//@Column(name="cantidad_inicial")
	//private Long cantidadInicial;
	
	@Column(name="cantidad_disponible")
	private Long cantidadDisponible;

	@ManyToMany
	@JoinTable(name = "menus_productos",joinColumns = @JoinColumn(name="pk_producto"),
	inverseJoinColumns = @JoinColumn(name="pk_menu"))
	private List<Menu>menu;
	
	@JoinColumn(name="fk_proveedor", referencedColumnName="pk_proveedor")
	@ManyToOne
	private Proveedor proveedor;

	public Producto() {
		super();
	}

	public Producto(Long id) {
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

	public Long getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Long cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
	
	
	
}
