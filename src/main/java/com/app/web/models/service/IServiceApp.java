package com.app.web.models.service;

import java.util.List;

import com.app.web.models.entity.cliente;
import com.app.web.models.entity.producto;
import com.app.web.models.entity.venta;



public interface IServiceApp {
	public List<producto> ListarProducto(String nombre); 
	public producto buscarProductoId(Integer id);	
	
	public List<cliente> listarClientes();
	public cliente buscarClienteId(Integer id);
	public void guardarCliente(cliente cliente);
	public void eliminarClienteId(Integer id);

	public void guardarVenta(venta venta);
	public void eliminarVentaId(Integer id);
	public List<venta> listarVentas();

}
