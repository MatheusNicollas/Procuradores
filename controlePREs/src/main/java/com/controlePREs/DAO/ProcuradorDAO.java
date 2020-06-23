package com.controlePREs.DAO;

import org.springframework.data.repository.CrudRepository;

import com.controlePREs.models.Procurador;

public interface ProcuradorDAO extends CrudRepository<Procurador, Integer>{
	Procurador findById(long id);
}
