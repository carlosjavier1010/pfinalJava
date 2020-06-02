package es.cjweb.fct.apirest.models.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cjweb.fct.apirest.models.dao.ICitaDao;
import es.cjweb.fct.apirest.models.dao.IUserDao;
import es.cjweb.fct.apirest.models.entity.Cita;
import es.cjweb.fct.apirest.models.entity.Usuario;

@Service
public class CitaServiceImpl implements ICitaService{
	
	@Autowired
	private ICitaDao citaDao;
	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<Cita> findAll() {
		
		return (List<Cita>) citaDao.findAll();
	}

	@Override
	public Cita findById(Integer id) {
		
		return citaDao.findById(id).orElse(null);
	}

	@Override
	public Cita save(Cita cita) {
		return citaDao.save(cita);
		
	}
	
	@Override
	public List<Cita> findAllByUserOrderByFechaDesc(Integer id) {
		Optional<Usuario> usuario = userDao.findById(id);
		
		return citaDao.findAllByUserOrderByFechaDesc(usuario);
	}

	@Override
	public void delete(Integer id) {
		citaDao.deleteById(id);
		
	}

	@Override
	public List<Cita> findAllByFecha(String fecha) {
		
		Date fechaNueva = null;
		Date fechaFin = null;
		String fechaF= fecha;
		fechaF = fechaF.concat(" 22:00");
		try {
			fecha = fecha.concat(" 08:00");
			fechaNueva = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(fecha);
			fechaFin = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(fechaF);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return citaDao.findAllByFecha(fechaNueva,fechaFin);
	}
}
