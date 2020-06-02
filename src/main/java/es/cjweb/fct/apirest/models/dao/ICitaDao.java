package es.cjweb.fct.apirest.models.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.cjweb.fct.apirest.models.entity.Cita;
import es.cjweb.fct.apirest.models.entity.Usuario;

public interface ICitaDao extends JpaRepository<Cita, Integer>{
	
	List<Cita> findAllByUserOrderByFechaDesc(Optional<Usuario> usuario);
	
	@Query("select c from Cita c where c.fecha BETWEEN :fecha and :fechaf")
    List<Cita> findAllByFecha(@Param("fecha") Date fecha, @Param("fechaf") Date fechaf);
}
