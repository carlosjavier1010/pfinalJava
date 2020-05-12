package es.cjweb.fct.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cjweb.fct.apirest.models.entity.Ranking;

public interface IRankingDao extends JpaRepository<Ranking, Integer> {

}
