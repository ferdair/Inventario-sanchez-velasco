package com.sanchez.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanchez.inventario.models.entities.Consumo;
import com.sanchez.inventario.models.entities.ConsumoMenu;
import com.sanchez.inventario.models.entities.Menu;
import com.sanchez.inventario.models.services.IConsumoMenuServices;
import com.sanchez.inventario.models.services.IConsumoService;
import com.sanchez.inventario.models.services.IMenuService;

@Controller
@RequestMapping(value="/consumo_menu")  

public class ConsumoMenuController {

	@Autowired 
	private IConsumoService srConsumo;
	@Autowired 
	private IMenuService srvMenu;
	@Autowired 
	private IConsumoMenuServices srvConsumoMenu;

	
	

	@GetMapping(value="/create") //https://localhost:8080/alumno/create
	public String create(Model model) {
		ConsumoMenu consumomenu = new ConsumoMenu();
		model.addAttribute("title", "Registro de nuevo Consumo");
		model.addAttribute("consumo_menu", consumomenu); //similar al ViewBag
		List<Consumo> consumos=srConsumo.findAll();
		model.addAttribute("consumos", consumos);
		
		List<Menu> menus=srvMenu.findAll();
		model.addAttribute("menus", menus);
		return "consumo_menu/form"; //la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		ConsumoMenu consumo = srvConsumoMenu.findById(id);
		model.addAttribute("consumo_menu", consumo);				
		return "consumo_menu/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		ConsumoMenu consumo = srvConsumoMenu.findById(id);
		model.addAttribute("consumo_menu", consumo);
		model.addAttribute("title", "Actualizando el registro de " + consumo);
		
		List<Consumo> consumos=srConsumo.findAll();
		model.addAttribute("consumos", consumos);
		List<Menu> menus=srvMenu.findAll();
		model.addAttribute("menus", menus);
		return "consumo_menu/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srConsumo.delete(id);
		return "redirect:/consumo_menu/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<ConsumoMenu> consumos = srvConsumoMenu.findAll();
		model.addAttribute("consumos_menu", consumos);
		model.addAttribute("title", "Listado de Consumos Menus");
		return "consumo_menu/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(ConsumoMenu consumo, Model model) {
		srvConsumoMenu.save(consumo);
		return "redirect:/consumo_menu/list";
	}
		
}
