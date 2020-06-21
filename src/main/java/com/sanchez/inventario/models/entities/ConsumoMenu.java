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
	private Long id;
	
	@ManyToOne
	 @JoinColumn(name = "fk_consumo")
	private Consumo consumo;
	
	@ManyToOne
	 @JoinColumn(name = "fk_menu")
	private Menu menu;
	
	 @Column(name="cantidad_menu")
	 private int cantidadMenu;
	

}
