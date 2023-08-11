package com.app.web.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.web.models.entity.cliente;
import com.app.web.models.entity.producto;
import com.app.web.models.entity.venta;
import com.app.web.models.entity.ventaproducto;
import com.app.web.models.service.IServiceApp;

@Controller
@SessionAttributes("venta")
public class VentaController {
	@Autowired
	private IServiceApp iServiceApp;
	@GetMapping({"/carritocompras"})
	public String carritocompras(Model model,HttpSession session) {
		List<ventaproducto> lstventa =new ArrayList<ventaproducto>();
		//model.addAttribute("producto", iServiceApp.ListarProducto(""));
		
		if(session.getAttribute("scarrito")==null) {
			lstventa =new ArrayList<ventaproducto>();			
		}else {
			lstventa=(List<ventaproducto>) session.getAttribute("scarrito");
		}
		
		double total=0;
		for (int i = 0; i < lstventa.size(); i++) {
			ventaproducto ventaproducto =  lstventa.get(i);
			total=total+ventaproducto.calcularSubtotal();
		}
		
		model.addAttribute("ventasproductos", lstventa);
		model.addAttribute("totales", total);
		return "carritocompras";
	}
	@GetMapping({"/metododespacho"})
	public String metododespacho(Model model,HttpSession session) {
		List<ventaproducto> lstventa =new ArrayList<ventaproducto>();
		venta ventacab=new venta();
		//model.addAttribute("producto", iServiceApp.ListarProducto(""));
		
		if(session.getAttribute("cabcarrito")==null) {
			ventacab=new venta();			
		}else {
			ventacab=(venta) session.getAttribute("cabcarrito");
		}
		
		if(session.getAttribute("scarrito")==null) {
			lstventa =new ArrayList<ventaproducto>();			
		}else {
			lstventa=(List<ventaproducto>) session.getAttribute("scarrito");
		}
		double total=0;
		for (int i = 0; i < lstventa.size(); i++) {
			ventaproducto ventaproducto =  lstventa.get(i);
			total=total+ventaproducto.calcularSubtotal();
		}
		model.addAttribute("ventasproductos", lstventa);
		model.addAttribute("totales", total);
		return "metododespacho";
	}
	@GetMapping(value = "/agregarcarrito/{id}", produces= {"application/json"})
	public @ResponseBody List<ventaproducto> agregarcarrito(@PathVariable Integer id,HttpSession session) {
		//model.addAttribute("producto", iServiceApp.ListarProducto(""));
		producto prod=iServiceApp.buscarProductoId(id);
		ventaproducto ventaprod=new ventaproducto();
		List<ventaproducto> lstventa =new ArrayList<ventaproducto>();
		int indicador=0;
		if(session.getAttribute("scarrito")==null) {
			ventaprod.setCantidad(1);
			ventaprod.setProducto(prod);
			lstventa.add(ventaprod);
			session.setAttribute("scarrito", lstventa);
			
		}else {
			lstventa=(List<ventaproducto>) session.getAttribute("scarrito");
			for (int i = 0; i < lstventa.size(); i++) {
				ventaproducto ventaproducto =  lstventa.get(i);
				if(ventaproducto.getProducto().getId()==id) {
					int cantidad=ventaproducto.getCantidad();
					cantidad=cantidad+1;
					ventaproducto.setCantidad(cantidad);
					lstventa.set(i, ventaproducto);
					indicador=1;
				}
			}
			if(indicador==0) {
				ventaprod.setCantidad(1);
				ventaprod.setProducto(prod);
				lstventa.add(ventaprod);
				
			}
			

		}


		
		return lstventa;
	}
	@GetMapping(value = "/agregardespacho/{metododespacho}/{direccion}/{distrito}/{telefono}/{dni_receptor}/{tienda_recojo}", produces= {"application/json"})
	public @ResponseBody venta  agregardespacho(@PathVariable Integer metododespacho,
			@PathVariable String direccion,@PathVariable String distrito,@PathVariable String telefono,
			@PathVariable String dni_receptor,@PathVariable String tienda_recojo,HttpSession session) {
		venta ventacab=new venta();
		//model.addAttribute("producto", iServiceApp.ListarProducto(""));
		
		if(session.getAttribute("cabcarrito")==null) {
			ventacab=new venta();			
		}else {
			ventacab=(venta) session.getAttribute("cabcarrito");
		}
		
		ventacab.setMetodoDespacho(metododespacho);
		ventacab.setDireccion(direccion);
		ventacab.setDistrito(distrito);
		ventacab.setTelefono(telefono);
		ventacab.setDniReceptor(dni_receptor);
		ventacab.setTiendaRecojo(tienda_recojo);
		//session.setAttribute("cabcarrito",ventacab);
		return ventacab;
	}
	
	
	
	@GetMapping({"/metodopago"})
	public String metodopago(Model model,HttpSession session) {
		List<ventaproducto> lstventa =new ArrayList<ventaproducto>();
		venta ventacab=new venta();
		//model.addAttribute("producto", iServiceApp.ListarProducto(""));
		
		if(session.getAttribute("cabcarrito")==null) {
			ventacab=new venta();			
		}else {
			ventacab=(venta) session.getAttribute("cabcarrito");
		}
		
		if(session.getAttribute("scarrito")==null) {
			lstventa =new ArrayList<ventaproducto>();			
		}else {
			lstventa=(List<ventaproducto>) session.getAttribute("scarrito");
		}
		double total=0;
		for (int i = 0; i < lstventa.size(); i++) {
			ventaproducto ventaproducto =  lstventa.get(i);
			total=total+ventaproducto.calcularSubtotal();
		}
		model.addAttribute("ventasproductos", lstventa);
		model.addAttribute("totales", total);
		return "metodopago";
	}
	
	
	@GetMapping({"/confirmacion"})
	public String confirmacion(Model model,HttpSession session) {
		List<ventaproducto> lstventa =new ArrayList<ventaproducto>();
		venta ventacab=new venta();
		session.setAttribute("cabcarrito", ventacab);
		session.setAttribute("scarrito", lstventa );
		/*
		//model.addAttribute("producto", iServiceApp.ListarProducto(""));
		
		if(session.getAttribute("cabcarrito")==null) {
			ventacab=new venta();			
		}else {
			ventacab=(venta) session.getAttribute("cabcarrito");
		}
		
		if(session.getAttribute("scarrito")==null) {
			lstventa =new ArrayList<ventaproducto>();			
		}else {
			lstventa=(List<ventaproducto>) session.getAttribute("scarrito");
		}
		double total=0;
		for (int i = 0; i < lstventa.size(); i++) {
			ventaproducto ventaproducto =  lstventa.get(i);
			total=total+ventaproducto.calcularSubtotal();
		}
		model.addAttribute("ventasproductos", lstventa);
		model.addAttribute("totales", total);*/
		return "confirmacion";
	}
	
	@GetMapping(value = "/registrarventa/{codpago}/{dni_titular}/{nombre_titular}/{numero_titular}", produces= {"application/json"})
	public @ResponseBody venta  registrarventa(@PathVariable String codpago,
			@PathVariable String dni_titular,@PathVariable String nombre_titular,@PathVariable String numero_titular,HttpSession session) {
		
		venta ventacab=new venta();
		/*
		ventacab.setDescripcion("1");
		ventacab.setDireccion("1");
		ventacab.setDistrito("1");;
		ventacab.setDniReceptor("1");
		ventacab.setDniTitular("1");
		ventacab.setMetodoDespacho(1);;
		ventacab.setNombreTitular("1");
		ventacab.setNumeroTarjeta("1");*/
		
		if(session.getAttribute("cabcarrito")==null) {
			ventacab=new venta();			
		}else {
			ventacab=(venta) session.getAttribute("cabcarrito");
		}
		ventacab.setCodPago(codpago);
		ventacab.setDniTitular(dni_titular);
		ventacab.setNombreTitular(nombre_titular);
		ventacab.setNumeroTarjeta(numero_titular);
		
		List<ventaproducto> lstventa =new ArrayList<ventaproducto>();
		if(session.getAttribute("scarrito")==null) {
			lstventa =new ArrayList<ventaproducto>();			
		}else {
			lstventa=(List<ventaproducto>) session.getAttribute("scarrito");
		}
		ventacab.setItems(lstventa);
		cliente cli=iServiceApp.buscarClienteId(1);
		ventacab.setCliente(cli);
		iServiceApp.guardarVenta(ventacab);		
		return ventacab;
		
	}

	
}
