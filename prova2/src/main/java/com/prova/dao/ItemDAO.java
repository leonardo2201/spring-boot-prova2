package com.prova.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.prova.model.Item;

@Transactional
public interface ItemDAO extends CrudRepository<Item, Integer> {

}
