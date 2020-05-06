package es.cjweb.fct.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ranking")

public class Ranking implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod_rank;
	
	private int posicion;
	
	//Relación 1 Ranking M usuarios, mapeado por la clave foranea cod rank en la entidad user, tipo cascada para en caso de
	//borrado del usuario se borren los registros hijos en esta entidad ranking.
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cod_rank", cascade = CascadeType.ALL)
	private List<User> users;
	
	
	
	public Ranking() {
		this.users = new ArrayList<User>();
	}
	public int getCod_rank() {
		return cod_rank;
	}
	public void setCod_rank(int cod_rank) {
		this.cod_rank = cod_rank;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	 
	
}
