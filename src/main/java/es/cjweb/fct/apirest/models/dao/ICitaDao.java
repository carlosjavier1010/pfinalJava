package es.cjweb.fct.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cjweb.fct.apirest.models.entity.Cita;

public interface ICitaDao extends JpaRepository<Cita, Integer>{

}
