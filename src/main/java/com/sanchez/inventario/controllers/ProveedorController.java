package com.sanchez.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanchez.inventario.models.entities.Proveedor;
import com.sanchez.inventario.models.services.IProveedorService;

@Controller
@RequestMapping(value="/proveedor")  
public class ProveedorController {

	
	@Autowired 
	private IProveedorService srvProveedor;
	

	
	@GetMapping(value="/create") //https://localhost:8080/alumno/create
	public String create(Model model) {
		Proveedor proveedor = new Proveedor();
		model.addAttribute("title", "Registro de nuevo Proveedor");
		model.addAttribute("proveedor", proveedor); //similar al ViewBag
		return "proveedor/form"; //la ubicación de la vista
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Proveedor proveedor = srvProveedor.findById(id);
		model.addAttribute("proveedor", proveedor);				
		return "proveedor/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Proveedor proveedor = srvProveedor.findById(id);
		model.addAttribute("proveedor", proveedor);
		model.addAttribute("title", "Actualizando el registro de " + proveedor);
		return "proveedor/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvProveedor.delete(id);
		return "redirect:/proveedor/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Proveedor> proveedores = srvProveedor.findAll();
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("title", "Listado de Proveedores");
		return "proveedores/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Proveedor proveedor, Model model) {
		srvProveedor.save(proveedor);
		return "redirect:/proveedor/list";
	}

}
