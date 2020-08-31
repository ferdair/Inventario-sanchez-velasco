package com.sanchez.inventario.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sanchez.inventario.models.entities.Consumo;
import com.sanchez.inventario.models.entities.ConsumoMenu;
import com.sanchez.inventario.models.entities.Menu;
import com.sanchez.inventario.models.entities.Usuario;
import com.sanchez.inventario.models.services.IConsumoService;
import com.sanchez.inventario.models.services.IMenuService;
import com.sanchez.inventario.models.services.IUsuarioService;


@Controller
@SessionAttributes("consumo")
@RequestMapping(value="/consumo")  
public class ConsumoController {
	
	@Autowired 
	private IConsumoService srConsumo;
	@Autowired 
	private IUsuarioService srvUsuario;
	@Autowired 
	private IMenuService srvMenu;

	
	//Cada método en el controlador gestiona una petición al backend
	//a traves de una URL (puede ser -> 1. Escrita en el navegador
	//2. Puede sr Hyperlink, 3. Puede ser un action de un Form)
	
	@GetMapping(value="/create") //https://localhost:8080/alumno/create
	public String create(Model model) {
		Consumo consumo = new Consumo();
		model.addAttribute("title", "Registro de nuevo Consumo");
		model.addAttribute("consumo", consumo); //similar al ViewBag
		List<Usuario> usuarios=srvUsuario.findAll();
		model.addAttribute("usuarios", usuarios);
		List<Menu> menus=srvMenu.findAll();
		model.addAttribute("menus", menus);
		return "consumo/form"; //la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Consumo consumo = srConsumo.findById(id);
		model.addAttribute("consumo", consumo);	
		model.addAttribute("title", "Consulta de Consumo");

		return "consumo/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Consumo consumo = srConsumo.findById(id);
		model.addAttribute("consumo", consumo);
		model.addAttribute("title", "Actualizando el registro de " + consumo);
		List<Usuario> usuarios=srvUsuario.findAll();
		model.addAttribute("usuarios", usuarios);
		List<Menu> menus=srvMenu.findAll();
		model.addAttribute("menus", menus);
		return "consumo/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srConsumo.delete(id);
		return "redirect:/consumo/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Consumo> consumos = srConsumo.findAll();
		model.addAttribute("consumos", consumos);
		model.addAttribute("title", "Listado de Consumos");
		return "consumo/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Consumo consumo, Model model) {
		srConsumo.save(consumo);
		return "redirect:/consumo/list";
	}
	
	@PostMapping(value = "/add", produces = "application/json")
	public @ResponseBody Object add(@RequestBody @Valid ConsumoMenu consumoMenu, BindingResult result, Model model, HttpSession session) {

		try {
			Menu menu = srvMenu.findById(consumoMenu.getMenuid());
			consumoMenu.setMenu(menu);

			Consumo consumo= (Consumo)session.getAttribute("consumo");
			consumo.getMenus().add(consumoMenu);

			return consumoMenu;
		} catch (Exception e) {
			return e;
		}
	}
	
	@GetMapping(value = "/menues")
	public String menues(Model model, HttpSession session) {
		
		
		
		Consumo consumo= (Consumo)session.getAttribute("consumo");
		model.addAttribute("consumos_menu", consumo.getMenus());

		model.addAttribute("title", "Listado de Menús en el Consumo");
		return "consumo_menu/list";
	}
	



}
