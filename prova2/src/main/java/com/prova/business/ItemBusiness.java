package com.prova.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.dao.ItemDAO;
import com.prova.model.Item;

@Service
public class ItemBusiness {

	@Autowired
	private ItemDAO itemDAO;
	
	public List<Item> lista() {
		return (List<Item>) itemDAO.findAll();
	}
	
	public void save(Item item) {
		itemDAO.save( item );
	}
	
	public Optional<Item> findById(Integer id) {
		return itemDAO.findById( id );
	}
	
	public void delete(Integer id) {
		itemDAO.deleteById(id);
	}
	
}
