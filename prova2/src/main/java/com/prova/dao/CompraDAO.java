package com.prova.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.prova.model.Compra;

@Transactional
public interface CompraDAO extends CrudRepository<Compra, Integer> {

}
