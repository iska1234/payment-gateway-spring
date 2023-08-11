package com.app.web.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ventas")
public class venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String descripcion;
	@Column
	private String direccion;
	@Column
	private String distrito;
	@Column
	private String dni_receptor;
	@Column
	private String dni_titular;
	@Column
	private Integer metododespacho;
	@Column
	private String observacion;
	@Column
	private String telefono;
	@Column
	private String tienda_recojo;
	@Column
	private String codpago;
	@Column
	private String nombre_titular;
	@Column
	private String numero_tarjeta;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaCreacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_id", nullable = false)
	private cliente cliente;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "venta_id", nullable = false)
	private List<ventaproducto> items;
    

	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();
	}
	
	public venta() {
		items = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito= distrito;
	}
	public String getDniReceptor() {
		return dni_receptor;
	}
	public void setDniReceptor(String dni_receptor) {
		this.dni_receptor = dni_receptor;
	}
	public String getDniTitular() {
		return dni_titular;
	}
	public void setDniTitular(String dni_titular) {
		this.dni_titular = dni_titular;
	}
	public Integer getMetodoDespacho() {
		return metododespacho;
	}
	public void setMetodoDespacho(Integer metododespacho) {
		this.metododespacho = metododespacho;
	}

	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCodPago() {
		return codpago;
	}
	public void setCodPago(String codpago) {
		this.codpago= codpago;
	}

	public String getNombreTitular() {
		return nombre_titular;
	}
	public void setNombreTitular(String nombre_titular) {
		this.nombre_titular = nombre_titular;
	}
	public String getNumeroTarjeta() {
		return numero_tarjeta;
	}
	public void setNumeroTarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}
	public String getTiendaRecojo() {
		return tienda_recojo;
	}
	public void setTiendaRecojo(String tienda_recojo) {
		this.tienda_recojo = tienda_recojo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public cliente getCliente() {
		return cliente;
	}
	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ventaproducto> getItems() {
		return items;
	}
	public void setItems(List<ventaproducto> items) {
		this.items = items;
	}
	public void setItem(ventaproducto item) {
		items.add(item);
	}
	public Double calcularTotal() {
		Double total = 0.0;
		for (ventaproducto item : items) {
			total += item.calcularSubtotal();
		}
		return total;
	}
	public Double calcularSubTotal() {
		Double total = 0.0;
		total=this.calcularTotal()/1.18;
		return total;
	}
	public Double calcularIgv() {
		Double total = 0.0;
		total=this.calcularTotal()-this.calcularSubTotal();
		return total;
	}
	
}
