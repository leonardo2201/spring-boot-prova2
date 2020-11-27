package com.prova.business;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.dao.CompraDAO;
import com.prova.model.Compra;

@Service
public class CompraBusiness {

	@Autowired
	private CompraDAO compraDAO;
	
	public List<Compra> lista() {
		return (List<Compra>) compraDAO.findAll();
	}
	
	public void save(Compra compra) {
		compra.setData( new Date() );
		compra.setTotal( compra.getItem().getPreco() );
		compraDAO.save( compra );
		
	}
	
	public Optional<Compra> findById(Integer id) {
		return compraDAO.findById( id );
	}
	
	public void delete(Integer id) {
		compraDAO.deleteById(id);
	}
	
}
