package es.cjweb.fct.apirest.models.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="rankings")

public class Ranking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int posicion;
	
	//Relación 1 Ranking 1 usuarios, mapeado por la clave foranea cod rank en la entidad user, tipo cascada para en caso de
	//borrado del usuario se borren el registro hijo en esta entidad ranking.
	@OneToOne(mappedBy = "ranking", cascade = CascadeType.ALL)
	private User user;
	
	
	
	public Ranking() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	
}
