package com.sanchez.inventario.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity  
@Table(name="consumos")
public class Consumo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="pk_consumo")	
	private Integer id;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha")
	private Calendar fecha;
	
	@JsonIgnore
	@OneToMany(mappedBy = "consumo",fetch=FetchType.LAZY)
	private List<ConsumoMenu> menus;
	
	@JoinColumn(name="fk_usuario", referencedColumnName="pk_usuario")
	@ManyToOne
	private Usuario usuario;
	

	public Consumo() {
		super();
	}

	public Consumo(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	


	public List<ConsumoMenu> getMenus() {
		if (menus==null) {
			menus=new ArrayList<ConsumoMenu>();
		}
		return menus;
	}

	public void setMenus(List<ConsumoMenu> menus) {
		this.menus = menus;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String fechaNac() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fecha.getTime());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.fechaNac()+"-"+this.getUsuario();
	}
	
	
	
	

}
