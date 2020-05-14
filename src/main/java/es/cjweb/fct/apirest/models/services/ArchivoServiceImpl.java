package es.cjweb.fct.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cjweb.fct.apirest.models.dao.IArchivoDao;
import es.cjweb.fct.apirest.models.entity.Archivo;

@Service
public class ArchivoServiceImpl implements IArchivoService{
	
	@Autowired
	private IArchivoDao archivoDao;
	
	@Override
	public List<Archivo> findAll() {
		
		return (List<Archivo>) archivoDao.findAll();
	}

	@Override
	public Archivo findById(Integer id) {
		
		return archivoDao.findById(id).orElse(null);
	}

	@Override
	public Archivo findByUserId(Integer id) {
		
		return archivoDao.findByUserId(id).orElse(null);
	}
}
