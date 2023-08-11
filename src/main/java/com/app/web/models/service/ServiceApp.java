package com.app.web.models.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.models.dao.IProducto;
import com.app.web.models.dao.IVenta;
import com.app.web.models.entity.producto;
import com.app.web.models.entity.venta;
import com.app.web.models.dao.ICliente;
import com.app.web.models.entity.cliente;

@Service
public class ServiceApp implements IServiceApp  {

	@Autowired
	private IProducto iProducto;
	
	@Autowired
	private ICliente iCliente;
	
	@Autowired
	private IVenta iVenta;
	
	@Override
	public List<producto> ListarProducto(String nombre) {
		// TODO Auto-generated method stub
		return iProducto.findByNombreLikeIgnoreCase("%" + nombre + "%");
	}

	@Override
	public producto buscarProductoId(Integer id) {
		// TODO Auto-generated method stub
		return iProducto.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public List<cliente> listarClientes() {
		return (List<cliente>) iCliente.findAll();
	}

	@Override
	@Transactional
	public cliente buscarClienteId(Integer id) {
		return iCliente.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void guardarCliente(cliente cliente) {
		iCliente.save(cliente);
	}

	@Override
	@Transactional
	public void eliminarClienteId(Integer id) {
		iCliente.deleteById(id);
	}
	
	@Override
	@Transactional
	public void guardarVenta(venta venta) {
		iVenta.save(venta);
	}

	@Override
	@Transactional
	public void eliminarVentaId(Integer id) {
		iVenta.deleteById(id);
	}
	@Override
	public List<venta> listarVentas() {
		// TODO Auto-generated method stub
	
		return (List<venta>)iVenta.findAll();
	}

}
