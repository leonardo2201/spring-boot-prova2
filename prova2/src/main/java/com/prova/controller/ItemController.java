package com.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prova.business.ItemBusiness;
import com.prova.model.Item;

@Controller
public class ItemController {

	@Autowired
	private ItemBusiness itemBusiness;
	
	@GetMapping("/item/lista")
	public String lista() {
		
		ModelMap model = new ModelMap();
		model.addAttribute("items", itemBusiness.lista());
		model.addAttribute("item", new Item());
		return "index-item";
		
	}
	
	@GetMapping("/item/save")
	public String save(Item item) {
		if(item.getTipo() == null || item.getPreco() == null ) {
			return "index-item";
		}
		itemBusiness.save( item );
		return "index-item";
	}
	
	@GetMapping("/item/delete")
	public String delete(Integer id) {
		itemBusiness.delete( id );
		return null;
	}
	
	@GetMapping("/item/{id}")
	public String findById(@RequestParam Integer id) {
		itemBusiness.findById( id );
		return null;
	}
}
