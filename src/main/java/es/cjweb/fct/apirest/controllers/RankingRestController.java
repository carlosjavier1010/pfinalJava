package es.cjweb.fct.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.cjweb.fct.apirest.models.entity.Ranking;
import es.cjweb.fct.apirest.models.services.IRankingService;

@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class RankingRestController {

	@Autowired
	private IRankingService rankingService;
	
	@RequestMapping(value="/ranking",method=RequestMethod.GET)
	public List<Ranking> findAll(){
		return this.rankingService.findAll();
	}
	
	@RequestMapping(value="/ranking/{id}",method=RequestMethod.GET)
	public Ranking findById(@PathVariable("id") Integer id){
		//prueba cambiandole el codigo del ranking a un usuario
		/*if (id==2) {
			User uno = this.userService.findById(1);
			uno.setCod_rank(1);
			
			this.userService.save(uno);
		}*/
		
		return this.rankingService.findById(id);
	}
	
	
}
