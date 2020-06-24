package com.sanchez.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanchez.inventario.models.entities.Usuario;
import com.sanchez.inventario.models.services.IUsuarioService;

@Controller
@RequestMapping(value="/usuario")  
public class UsuarioController {
	@Autowired 
	private IUsuarioService srvUsuario;
	

	
	@GetMapping(value="/create") //https://localhost:8080/alumno/create
	public String create(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("title", "Registro de nuevo Usuario");
		model.addAttribute("usuario", usuario); //similar al ViewBag
		return "usuario/form"; //la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Usuario usuario = srvUsuario.findById(id);
		model.addAttribute("usuario", usuario);				
		return "usuario/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Usuario usuario = srvUsuario.findById(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Actualizando el registro de " + usuario);
		return "usuario/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvUsuario.delete(id);
		return "redirect:/usuario/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Usuario> usuarios = srvUsuario.findAll();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("title", "Listado de Usuarios");
		return "usuario/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Usuario usuario, Model model) {
		srvUsuario.save(usuario);
		return "redirect:/usuario/list";
	}

}
