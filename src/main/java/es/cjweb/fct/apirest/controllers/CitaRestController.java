package es.cjweb.fct.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.cjweb.fct.apirest.models.entity.Cita;
import es.cjweb.fct.apirest.models.entity.User;
import es.cjweb.fct.apirest.models.services.ICitaService;
import es.cjweb.fct.apirest.models.services.IUserService;

@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class CitaRestController {
	
	@Autowired
	private ICitaService citaService;
	
	@RequestMapping(value="/citas",method=RequestMethod.GET)
	public List<Cita> findAll(){
		return this.citaService.findAll();
	}
	
	@RequestMapping(value="/citas/{id}",method=RequestMethod.GET)
	public Cita findById(@PathVariable("id") Integer id){
		return this.citaService.findById(id);
	}
	
	
}
