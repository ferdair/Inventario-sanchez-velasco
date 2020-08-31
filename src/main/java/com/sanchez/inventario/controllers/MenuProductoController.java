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
import com.sanchez.inventario.models.entities.MenuProducto;
import com.sanchez.inventario.models.entities.Producto;
import com.sanchez.inventario.models.services.IMenuProductoService;
import com.sanchez.inventario.models.services.IMenuService;
import com.sanchez.inventario.models.services.IProductoService;



@Controller
@RequestMapping(value="/menu_producto")  
public class MenuProductoController {

	@Autowired 
	private IProductoService srvProducto;
	
	@Autowired 
	private IMenuService srvMenu;
	@Autowired 
	
	private IMenuProductoService srvMenuProducto;

	
	

	@GetMapping(value="/create") //https://localhost:8080/alumno/create
	public String create(Model model) {
		MenuProducto menuproducto = new MenuProducto();
		model.addAttribute("title", "Registro de nuevo Producto ");
		model.addAttribute("menu_producto", menuproducto); //similar al ViewBag
		List<Producto> productos = srvProducto.findAll();
		model.addAttribute("productos", productos);
		
		
		return "menu_producto/form"; //la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		MenuProducto menuproducto = srvMenuProducto.findById(id);
		model.addAttribute("menu_producto", menuproducto);				
		return "menu_producto/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		MenuProducto menuproducto = srvMenuProducto.findById(id);
		model.addAttribute("title", "Registro de nuevo Producto ");
		model.addAttribute("menu_producto", menuproducto); //similar al ViewBag
		List<Producto> productos = srvProducto.findAll();
		model.addAttribute("productos", productos);
		
		List<Menu> menus=srvMenu.findAll();
		model.addAttribute("menus", menus);
		return "menu_producto/form"; //la ubicación de la vista	}
	}
	
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvMenuProducto.delete(id);
		return "redirect:/menu_producto/form/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<MenuProducto> menuproducto = srvMenuProducto.findAll();
		model.addAttribute("menu_producto",menuproducto);
		model.addAttribute("title", "Listado de Productos Menu");
		return "menu_producto/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(MenuProducto menuproductos, Model model) {
		srvMenuProducto.save(menuproductos);
		return "redirect:/menu_producto/list";
	}

}
