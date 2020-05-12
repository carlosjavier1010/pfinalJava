package es.cjweb.fct.apirest.models.services;

import java.util.List;


import es.cjweb.fct.apirest.models.entity.User;

public interface IUserService {
	
	//Listado de usuarios completo
	public List<User> findAll();
	
	//Un unico usuario por su id
	
	public User findById(Integer id);

	public User save(User user);
	
	
}
