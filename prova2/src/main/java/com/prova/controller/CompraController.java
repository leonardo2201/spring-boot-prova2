package com.prova.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prova.business.CompraBusiness;
import com.prova.business.ItemBusiness;
import com.prova.model.Compra;
import com.prova.model.Item;

@Controller
public class CompraController {

	@Autowired
	private CompraBusiness compraBusiness;
	
	@Autowired
	private ItemBusiness itemBusiness;
	
	@GetMapping("/compra/lista")
	public ModelAndView lista() {
		
		ModelAndView mav = new ModelAndView("index-compra");
		
		List<Item> itens = new ArrayList<Item>();
		
		mav.addObject("compras", compraBusiness.lista());
		itens = itemBusiness.lista();
		mav.addObject("itens", itens );
		Compra compra =  new Compra();
		mav.addObject("compra", compra );
		return mav;
		
	}
	
	@GetMapping("/compra/save")
	public String save(Compra compra, Integer id) {
		if(compra.getItem() == null) {
			return "redirect:/compra/lista";
		}
		
		compraBusiness.save( compra );
		return "redirect:/compra/lista";
	}
	
	@GetMapping("/compra/alterar")
	public ModelAndView update(Integer id) {
				
		ModelAndView mav = new ModelAndView("index-compra");
		
		Optional<Compra> compra = compraBusiness.findById(id);
		
		Compra compraView = new Compra();
		compraView.setId( id );
		compraView.setPessoa( compra.get().getPessoa() );
		compraView.setData( compra.get().getData() );
		compraView.setDescricao( compra.get().getDescricao() );
		compraView.setItem( compra.get().getItem() );
		compraView.setTotal( compra.get().getTotal() );
		
		mav.addObject("compras", compraBusiness.lista());
		mav.addObject("compra", compraView);
		mav.addObject("itens", itemBusiness.lista() );
		return mav;
	}
	
	@GetMapping("/compra/delete")
	public String delete(Integer id) {
		compraBusiness.delete( id );
		return "redirect:/compra/lista";
	}
	
	@GetMapping("/compra/{id}")
	public String findById(@RequestParam Integer id) {
		compraBusiness.findById( id );
		return null;
	}
}
