package es.cjweb.fct.apirest.controllers;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.cjweb.fct.apirest.models.entity.Cita;
import es.cjweb.fct.apirest.models.services.ICitaService;


@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class CitaRestController {
	
	@Autowired
	private ICitaService citaService;
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/citas",method=RequestMethod.GET)
	public List<Cita> findAll(){
		return this.citaService.findAll();
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/citas/{id}",method=RequestMethod.GET)
	public Cita findById(@PathVariable("id") Integer id){
		
		
		return this.citaService.findById(id);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/citas/fecha/{fecha}",method=RequestMethod.GET)
	public List<Cita> findAllByFecha(@PathVariable("fecha") String fecha){
		
		
		return this.citaService.findAllByFecha(fecha);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/citas/user/{id}",method=RequestMethod.GET)
	public List<Cita> findByUser(@PathVariable("id") Integer id){
		
	
		return this.citaService.findAllByUserOrderByFechaDesc(id);
	}
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/citas",method=RequestMethod.POST, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE},
			consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })	
	@ResponseStatus(HttpStatus.CREATED)
	public Cita create(@RequestBody Cita cita){
	
		return this.citaService.save(cita);
	}
	
	@RequestMapping(value="/citas/{id}",method=RequestMethod.PUT)
	public Cita update(@RequestBody Cita cita, @PathVariable Integer id){
		Cita citaActual = citaService.findById(id);
		citaActual.setFecha(cita.getFecha());
		citaActual.setEstado(cita.isEstado());
		return this.citaService.save(citaActual);
	}
	
	@RequestMapping(value="/citas/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id){
		
		this.citaService.delete(id);
	}
}
