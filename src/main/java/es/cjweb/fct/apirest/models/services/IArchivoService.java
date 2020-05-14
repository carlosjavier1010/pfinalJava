package es.cjweb.fct.apirest.models.services;

import java.util.List;

import es.cjweb.fct.apirest.models.entity.Archivo;

public interface IArchivoService {
	
	//Listado de cita completo
		public List<Archivo> findAll();
	
	//Una unica cita por su id
	
		public Archivo findById(Integer id);

		public Archivo findByUserId(Integer id);
}
