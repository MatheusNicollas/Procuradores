package com.controlePREs.DAO;

import org.springframework.data.repository.CrudRepository;
import com.controlePREs.models.Secretario;

public interface SecretarioDAO extends CrudRepository<Secretario, Integer>{
	Secretario findById(long id);
}
