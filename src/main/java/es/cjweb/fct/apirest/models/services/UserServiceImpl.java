package es.cjweb.fct.apirest.models.services;

import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cjweb.fct.apirest.models.dao.IUserDao;
import es.cjweb.fct.apirest.models.entity.Usuario;

@Service
public class UserServiceImpl implements IUserService , UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario user) {
		return userDao.save(user);
		
	}
	
	@Override
	public Usuario findByEmail(String username) {
		// TODO Apéndice de método generado automáticamente
		
		return userDao.findByEmail(username);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Como el email llega a traves de url, el simbolo @ es reemplazado por %40, entonces aqui antes
		//de buscar el usuario por el email, cambiamos el %40 por @
		 if(username.contains("%40")){
	            username = username.replace("%40","@");
	        }
		Usuario usuario = userDao.findByEmail(username);
		
		if (usuario == null) {
			logger.error("Error en el login: no existe el usuario "+username+" en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario "+username+" en el sistema!");
		}
		
		
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role "+authority.getAuthority()))
				.collect(Collectors.toList());
		return new User(usuario.getEmail(), usuario.getPass(), usuario.isVerified(), true, true, true, authorities);
	}

	@Override
	public Usuario findByNombre(String username) {
		// TODO Apéndice de método generado automáticamente
		return userDao.findByNombre(username);
	}

	@Override
	public void deleteById(Integer id) {
		userDao.deleteById(id);
		
	}


	

}
