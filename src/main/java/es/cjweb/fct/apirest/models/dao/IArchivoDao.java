package es.cjweb.fct.apirest.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cjweb.fct.apirest.models.entity.Archivo;



public interface IArchivoDao extends JpaRepository<Archivo , Integer>{

	Optional<Archivo> findByUserId(Integer id);

}
