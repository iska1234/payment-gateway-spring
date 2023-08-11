package com.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.app.web.models.entity.producto;

public interface IProducto extends CrudRepository<producto, Integer> {
	public List<producto>findByNombreLikeIgnoreCase(String term);
	public List<producto>findByMarcaLikeIgnoreCase(String term);
}
