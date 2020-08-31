package com.sanchez.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sanchez.inventario.models.entities.Producto;
import com.sanchez.inventario.models.services.IProductoService;

@Controller
@SessionAttributes("producto")
@RequestMapping(value="/producto")  
public class ProductoController {
	
	@Autowired 
	private IProductoService srvProducto;


	
	@GetMapping(value="/create") //https://localhost:8080/alumno/create
	public String create(Model model) {
		Producto producto = new Producto();
		model.addAttribute("title", "Registro de nuevo Producto");
		model.addAttribute("producto", producto); //similar al ViewBag
		return "producto/form"; //la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Producto producto = srvProducto.findById(id);
		model.addAttribute("title", "Consulta de Producto");

		model.addAttribute("producto", producto);				
		return "producto/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Producto producto = srvProducto.findById(id);
		model.addAttribute("producto", producto);
		model.addAttribute("title", "Actualizando el registro de " + producto);
				return "producto/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvProducto.delete(id);
		return "redirect:/producto/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Producto> productos = srvProducto.findAll();
		model.addAttribute("productos", productos);
		model.addAttribute("title", "Listado de Productos");
		return "producto/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Producto producto, Model model) {
		srvProducto.save(producto);
		return "redirect:/producto/list";
	}

	@GetMapping(value="/search/{criteria}", produces="application/json")
	public @ResponseBody List<Producto> search(@PathVariable(value="criteria") String criteria, 
			Model model) {
		List<Producto> lista = this.srvProducto.findByNombre(criteria);		
		return lista;		
	}
	
}
