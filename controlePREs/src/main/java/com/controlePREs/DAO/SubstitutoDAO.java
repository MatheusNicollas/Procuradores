package com.controlePREs.DAO;

import org.springframework.data.repository.CrudRepository;

import com.controlePREs.models.Substituto;

public interface SubstitutoDAO extends CrudRepository<Substituto, Integer>{
	Substituto findById(long id);
}
