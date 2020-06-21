package com.sanchez.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanchez.inventario.models.entities.Menu;
import com.sanchez.inventario.models.entities.Producto;
import com.sanchez.inventario.models.services.IMenuService;
import com.sanchez.inventario.models.services.IProductoService;

@Controller
@RequestMapping(value="/menu")  
public class MenuController {
	
	
	@Autowired 
	private IProductoService srvProducto;
	@Autowired 
	private IMenuService srvMenu;

	
	//Cada método en el controlador gestiona una petición al backend
	//a traves de una URL (puede ser -> 1. Escrita en el navegador
	//2. Puede sr Hyperlink, 3. Puede ser un action de un Form)
	
	@GetMapping(value="/create") //https://localhost:8080/alumno/create
	public String create(Model model) {
		Menu menu = new Menu();
		model.addAttribute("title", "Registro de nuevo Consumo");
		model.addAttribute("menu", menu); //similar al ViewBag
		List<Producto> productos=srvProducto.findAll();
		model.addAttribute("productos", productos);
		return "menu/form"; //la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Menu menu = srvMenu.findById(id);
		model.addAttribute("menu", menu);				
		return "menu/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Menu menu = srvMenu.findById(id);
		model.addAttribute("menu", menu);
		model.addAttribute("title", "Actualizando el registro de " + menu);
		List<Producto> productos=srvProducto.findAll();
		model.addAttribute("productos", productos);
		return "menu/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvMenu.delete(id);
		return "redirect:/menu/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Menu> menus = srvMenu.findAll();
		model.addAttribute("menus", menus);
		model.addAttribute("title", "Listado de Menús");
		return "menu/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Menu menu, Model model) {
		srvMenu.save(menu);
		return "redirect:/menu/list";
	}


}
