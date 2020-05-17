package es.cjweb.fct.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import es.cjweb.fct.apirest.models.entity.Usuario;
import es.cjweb.fct.apirest.models.services.IUserService;

@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/clientes",method=RequestMethod.GET)
	public List<Usuario> findAll(){
		return this.userService.findAll();
	}
	
	@RequestMapping(value="/clientes/{id}",method=RequestMethod.GET)
	public Usuario findById(@PathVariable("id") Integer id){
		//prueba cambiandole el codigo del ranking a un usuario
		/*if (id==2) {
			User uno = this.userService.findById(1);
			uno.setCod_rank(1);
			
			this.userService.save(uno);
		}*/
		
		return this.userService.findById(id);
	}
	
	
}
