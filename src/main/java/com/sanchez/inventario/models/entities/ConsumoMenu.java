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
@Table(name="consumo_menu")
public class ConsumoMenu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_consumo_menu")	
	private Integer id;
	
	@ManyToOne
	 @JoinColumn(name = "fk_consumo")
	private Consumo consumo;
	
	@ManyToOne
	 @JoinColumn(name = "fk_menu")
	private Menu menu;
	
	 @Column(name="cantidad_menu")
	 private int cantidadMenu;

	 
	public ConsumoMenu() {
		super();
	}
	
	public ConsumoMenu(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getCantidadMenu() {
		return cantidadMenu;
	}

	public void setCantidadMenu(int cantidadMenu) {
		this.cantidadMenu = cantidadMenu;
	}

	
	@Override
	public String toString() {
		return this.getCantidadMenu()+"";
	}
	
	 
	 
	 

}
