package com.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.web.models.entity.cliente;

public interface ICliente extends CrudRepository<cliente, Integer>  {

}
