package es.cjweb.fct.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cjweb.fct.apirest.models.dao.ICitaDao;
import es.cjweb.fct.apirest.models.entity.Cita;

@Service
public class CitaServiceImpl implements ICitaService{
	
	@Autowired
	private ICitaDao citaDao;
	
	@Override
	public List<Cita> findAll() {
		
		return (List<Cita>) citaDao.findAll();
	}

	@Override
	public Cita findById(Integer id) {
		
		return citaDao.findById(id).orElse(null);
	}

	@Override
	public void save(Cita cita) {
		citaDao.save(cita);
		
	}

	
}
