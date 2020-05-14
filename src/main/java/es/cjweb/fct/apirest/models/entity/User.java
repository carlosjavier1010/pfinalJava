package es.cjweb.fct.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
public class User implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String email;
	private String pass;
	private boolean verified;
	private String verification_token;
	private boolean user_admin;
	private int movil;
	@Column(name="fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fecha_registro;
	private String nombre;
	private String apellidos;
	private String foto;
	private int cod_rank;
	
	@OneToOne
	@JoinColumn(name="id")
	private Ranking ranking;
	
	//Relacion de un Usuario tiene muchas citas, mapeado por el atributo id_user de tipo User en la clase cita.
	@JsonIgnoreProperties(value={"user", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Cita> citas;
	
	@JsonIgnoreProperties(value={"user", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Archivo> archivos;

	public void setVerified(boolean verified) {
		this.verified = verified;
	}



	public User() {
		this.citas = new ArrayList<Cita>();
		this.archivos = new ArrayList<Archivo>();
	}



	@PrePersist
	public void prePersist() {
		this.fecha_registro = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id_user) {
		this.id = id_user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerify(boolean verified) {
		this.verified = verified;
	}
	public String getVerification_token() {
		return verification_token;
	}
	public void setVerification_token(String verification_token) {
		this.verification_token = verification_token;
	}
	public boolean isUser_admin() {
		return user_admin;
	}
	public void setUser_admin(boolean user_admin) {
		this.user_admin = user_admin;
	}
	public int getMovil() {
		return movil;
	}
	public void setMovil(int movil) {
		this.movil = movil;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	

	public int getCod_rank() {
		return cod_rank;
	}



	public void setCod_rank(int cod_rank) {
		this.cod_rank = cod_rank;
	}



	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
