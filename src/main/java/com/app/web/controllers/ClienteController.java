package com.app.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.web.models.entity.venta;
import com.app.web.models.service.IServiceApp;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	private IServiceApp iServiceApp;
	
	@GetMapping({"/micuenta"})
	public String buscarcliente(Model model) {
		model.addAttribute("cliente", iServiceApp.buscarClienteId(1));
		model.addAttribute("venta2", iServiceApp.listarVentas());
		/*
		List<venta> lst=iServiceApp.listarVentas();
		List<venta> lst1=new ArrayList<venta>();
		for (int i = 0; i < lst.size(); i++) {
			venta vent=new venta();
			vent=lst.get(i);
		}
		*/
		return "micuenta";
	}

}
