package es.cjweb.fct.apirest.models.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.cjweb.fct.apirest.models.entity.Cita;
import es.cjweb.fct.apirest.models.entity.Usuario;

public interface ICitaService {
	
	//Listado de cita completo
		public List<Cita> findAll();
	
	//Una unica cita por su id
	
		public Cita findById(Integer id);
		public List<Cita> findAllByUserOrderByFechaDesc(Integer id);
		public List<Cita> findAllByFecha(String fecha);
		public List<Cita> findAllByEstadoTrue();
		public List<Cita> findAllByEstadoFalse();
		public Cita save(Cita cita);
		public void delete(Integer id);
}
