package es.cjweb.fct.apirest.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import es.cjweb.fct.apirest.models.entity.Usuario;

public interface IUserDao extends JpaRepository<Usuario, Integer>{

	Usuario findByEmail(String username);

	


}
