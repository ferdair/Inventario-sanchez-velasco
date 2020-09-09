package com.sanchez.inventario.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sanchez.inventario.models.entities.Menu;
import com.sanchez.inventario.models.entities.MenuProducto;
import com.sanchez.inventario.models.entities.Producto;
import com.sanchez.inventario.models.services.IMenuService;
import com.sanchez.inventario.models.services.IProductoService;

@Controller
@SessionAttributes("menu")
@RequestMapping(value = "/menu")
public class MenuController {

	@Autowired
	private IProductoService srvProducto;
	@Autowired
	private IMenuService srvMenu;

	// Cada método en el controlador gestiona una petición al backend
	// a traves de una URL (puede ser -> 1. Escrita en el navegador
	// 2. Puede sr Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/alumno/create
	public String create(Model model) {
		Menu menu = new Menu();
		menu.setProductos(new ArrayList<MenuProducto>());
		model.addAttribute("title", "Registro de nuevo Menú");
		model.addAttribute("menu", menu); // similar al ViewBag
		List<Producto> productos = srvProducto.findAll();
		model.addAttribute("productos", productos);
		return "menu/form"; // la ubicación de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Integer id, Model model) {
		Menu menu = srvMenu.findById(id);
		model.addAttribute("menu", menu);
		model.addAttribute("title", "Consulta de Menú");

		return "menu/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Integer id, Model model) {
		Menu menu = srvMenu.findById(id);
		model.addAttribute("menu", menu);
		model.addAttribute("title", "Actualizando el registro de " + menu);
		List<Producto> productos = srvProducto.findAll();
		model.addAttribute("productos", productos);
		return "menu/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Integer id, Model model) {
		srvMenu.delete(id);
		return "redirect:/menu/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Menu> menus = srvMenu.findAll();
		model.addAttribute("menus", menus);
		model.addAttribute("title", "Listado de Menús");
		return "menu/list";
	}

	@PostMapping(value = "/save")
	public String save(@Validated Menu menu, BindingResult result, Model model,SessionStatus status, RedirectAttributes flash, HttpSession session) {
		
		try {
			String message = "Menú agregado con exito";
			String titulo = "Registro de un nueva Gira";
			
			if(menu.getId() != null) {
				message = "Menu actualizado con exito";
				titulo = "Actualizando Menú N°" + menu.getId();
			}
			
			if(result.hasErrors()) {
				model.addAttribute("title",titulo);
				model.addAttribute("error", "Error al agregar menú");
				List<Producto> productos = srvProducto.findAll();
				model.addAttribute("productos",productos);
				return "menu/form";
			}
			
			Menu menuSession=(Menu)session.getAttribute("menu");
			/*
			 * for (int i = 0; i < menuSession.getProductos().size()-1; i++) {
			 * menu.getProductos().add(menuSession.getProductos().get(i));
			 * 
			 * }
			 */
			
			System.out.print(menuSession.getConsumos());
			 
				/*
				 * for(MenuProducto p : menuSession.getProductos()) {
				 * menu.getProductos().add(p); }
				 */
			
			
			srvMenu.save(menu);
			status.setComplete();
			flash.addFlashAttribute("success", message);

			return "redirect:/menu/list";
			
		} catch (Exception e) {
			flash.addFlashAttribute("success", e.getMessage());
			
		}
		
		return "redirect:/menu/list";

	}

	@PostMapping(value = "/add", produces = "application/json")
	public @ResponseBody Object add(@RequestBody @Valid MenuProducto menuProducto, BindingResult result, Model model, HttpSession session) {
		

		try {
			Producto producto = srvProducto.findById(menuProducto.getProductoid());
			menuProducto.setProducto(producto);
			Menu menu= (Menu)session.getAttribute("menu");
			menu.getProductos().add(menuProducto);		

			
			return menuProducto;
		} catch (Exception e) {
			return e;
		}
	}
	
	@GetMapping(value = "/products")
	public String products(Model model, HttpSession session) {
		Menu menu= (Menu)session.getAttribute("menu");
		model.addAttribute("menu_producto", menu.getProductos());

		model.addAttribute("title", "Listado de Productos en el Menú");
		return "menu_producto/list";
	}
	
	@GetMapping(value="/search/{criteria}", produces="application/json")
	public @ResponseBody List<Menu> search(@PathVariable(value="criteria") String criteria, 
			Model model) {
		List<Menu> lista = this.srvMenu.findByNombre(criteria);		
		return lista;		
	}

}
