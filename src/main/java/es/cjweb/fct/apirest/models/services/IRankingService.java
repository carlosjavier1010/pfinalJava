package es.cjweb.fct.apirest.models.services;

import java.util.List;

import es.cjweb.fct.apirest.models.entity.Ranking;

public interface IRankingService{

	public List<Ranking> findAll();

	public Ranking findById(Integer id);

	public void save(Ranking create);

}
