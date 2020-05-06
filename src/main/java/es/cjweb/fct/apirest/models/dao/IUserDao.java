package es.cjweb.fct.apirest.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.cjweb.fct.apirest.models.entity.User;

public interface IUserDao extends JpaRepository<User, Integer>{


}
