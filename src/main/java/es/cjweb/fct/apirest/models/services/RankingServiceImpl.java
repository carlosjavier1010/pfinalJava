package es.cjweb.fct.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cjweb.fct.apirest.models.dao.IRankingDao;
import es.cjweb.fct.apirest.models.entity.Ranking;
import es.cjweb.fct.apirest.models.entity.Usuario;

@Service
public class RankingServiceImpl implements IRankingService {
	
	@Autowired
	private IRankingDao rankingDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Ranking> findAll() {
		// TODO Auto-generated method stub
		return (List<Ranking>) rankingDao.findAll();
	}

	@Override
	public Ranking findById(Integer id) {
		// TODO Apéndice de método generado automáticamente
		return rankingDao.findById(id).orElse(null);
	}
}
