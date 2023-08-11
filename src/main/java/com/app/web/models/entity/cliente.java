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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "clientes")
public class cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Column(length = 30, nullable = false)
	private String nombre;
	@NotBlank
	@Column(length = 30, nullable = false)
	private String apellidos;
	@NotBlank
	@Column(length = 20, nullable = false)
	private String nrodocumento;
	@NotBlank
	@Email
	@Column(length = 40, nullable = false)
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaCreacion;
	/*
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<venta> ventas;
   */
	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();
	}
	
	public cliente() {
		//ventas = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNroDocumento() {
		return nrodocumento;
	}

	public void setNroDocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
/*
	public List<venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<venta> ventas) {
		this.ventas = ventas;
	}

	public void setVenta(venta venta) {
		ventas.add(venta);
	}*/
}
