package es.cjweb.fct.apirest.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.cjweb.fct.apirest.models.entity.Archivo;
import es.cjweb.fct.apirest.models.services.IArchivoService;


@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class ArchivoRestController {
	
	@Autowired
	private IArchivoService archivoService;
	
	
	//Sacamos todos los archivos
	@RequestMapping(value="/archivos",method=RequestMethod.GET)
	public List<Archivo> findAll(){
		return this.archivoService.findAll();
	}
	
	//Sacamos un archivo por su id
	@RequestMapping(value="/archivos/{id}",method=RequestMethod.GET)
	public Archivo findById(@PathVariable("id") Integer id){
		return this.archivoService.findById(id);
	}
	
	
	//Sacamos los archivos de un usuario en concreto a traves de su id
	@RequestMapping(value="/archivos/user/{id}",method=RequestMethod.GET)
	public Archivo findByUserId(@PathVariable("id") Integer id){
		return this.archivoService.findByUserId(id);
	}
}
