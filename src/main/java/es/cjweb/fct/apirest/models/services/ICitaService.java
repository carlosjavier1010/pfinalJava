package es.cjweb.fct.apirest.models.services;

import java.util.List;

import es.cjweb.fct.apirest.models.entity.Cita;

public interface ICitaService {
	
	//Listado de cita completo
		public List<Cita> findAll();
	
	//Una unica cita por su id
	
		public Cita findById(Integer id);
}
