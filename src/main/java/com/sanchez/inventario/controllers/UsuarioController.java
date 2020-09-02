package com.sanchez.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanchez.inventario.models.entities.Usuario;
import com.sanchez.inventario.models.services.IUsuarioService;
import com.sanchez.inventario.models.services.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private IUsuarioService srvUsuario;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping(value = "/create")
	public String registro(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Registro de nuevo usuario");
		return "usuario/form";
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Integer id, Model model) {
		Usuario usuario = srvUsuario.findById(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Consulta de usuario");

		return "usuario/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Integer id, Model model) {
		Usuario usuario = srvUsuario.findById(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Actualizando el registro de " + usuario);
		return "usuario/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Integer id, Model model) {
		srvUsuario.delete(id);
		return "redirect:/usuario/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Usuario> usuarios = srvUsuario.findAll();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("title", "Listado de Usuarios");
		return "usuario/list";
	}

	@PostMapping(value = "/save")
	public String save(@Validated Usuario usuario, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			
			String message = "Usuario agregado con exito";
			String titulo = "Registro de un nuevo Usuario";
			
			if(usuario.getId()!= null) {
				message = "Gira actualizada con exito";
				titulo = "Actualizando Gira N°" + usuario.getId();
			}
			
			
			if (result.hasErrors()) {
				model.addAttribute("title", "Registro de nuevo usuario");
				model.addAttribute("usuario", usuario);
				return "usuario/form";
			}
			String pass = usuario.getPassword();
			usuario.setPassword(encoder.encode(pass));


			usuario.setHabilitado(true);
			service.save(usuario);
			flash.addFlashAttribute("success", "El usuario fue agregado con éxito.");
		} catch (Exception ex) {
			flash.addFlashAttribute("error", "El usuario no pudo ser agregado.");
		}
		return "redirect:/usuario/list";
	}

}
