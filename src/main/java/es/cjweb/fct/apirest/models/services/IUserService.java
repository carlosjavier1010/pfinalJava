package es.cjweb.fct.apirest.models.services;

import java.util.List;


import es.cjweb.fct.apirest.models.entity.Usuario;

public interface IUserService {
	
	//Listado de usuarios completo
	public List<Usuario> findAll();
	
	//Un unico usuario por su id
	
	public Usuario findById(Integer id);

	public Usuario save(Usuario user);
	
	public Usuario findByEmail(String username);

	public Usuario findByNombre(String username);


	public void deleteById(Integer id);
}
