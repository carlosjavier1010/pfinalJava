package es.cjweb.fct.apirest.models.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import es.cjweb.fct.apirest.models.entity.Usuario;

public interface IUserDao extends JpaRepository<Usuario, Integer>{

	Usuario findByEmail(String username);
	Usuario findByNombre(String username);
	
	// Añadir el transactional y modifing para eliminar por query
	@Transactional
	@Modifying
	@Query("delete from Usuario u where u.id = :id")
	void deleteById(@Param("id") Integer id);
	

	
}
