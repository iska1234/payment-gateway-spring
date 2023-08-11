package com.app.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.web.models.service.IServiceApp;

@Controller
@SessionAttributes("producto")
public class ProductoController {
	@Autowired
	private IServiceApp iServiceApp;
	@GetMapping({"/listar"})
	public String listar(Model model) {
		model.addAttribute("productos", iServiceApp.ListarProducto(""));
		return "listar";
	}
	@GetMapping({"/inicio","/"})
	public String inicio(Model model) {
		model.addAttribute("inicio", iServiceApp.ListarProducto(""));
		return "inicio";
	}
	@GetMapping({"/marca"})
	public String marca(Model model) {
		//model.addAttribute("marca", iServiceApp.ListarProducto(""));
		return "marca";
	}
	@GetMapping({"/seguimiento"})
	public String seguimiento(Model model) {
		//model.addAttribute("marca", iServiceApp.ListarProducto(""));
		return "seguimiento";
	}
}
