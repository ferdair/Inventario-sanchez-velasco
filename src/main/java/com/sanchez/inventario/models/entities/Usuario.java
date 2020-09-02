package com.sanchez.inventario.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "pk_usuario")
	private Integer id;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "nombre")//de usuario
	private String nombre;

	@Column(name = "contrato")
	private String contrato;


	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "habilitado")
	private boolean habilitado;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_usuario")
	private List<Rol> roles;

	public List<Rol> getRoles() {
		if (roles == null)
			roles = new ArrayList<>();
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	// UNO A VARIOS CON CONSUMO
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Consumo> consumos;

	public Usuario() {
		super();
	}

	public Usuario(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNombres();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	


	
	
	
}
