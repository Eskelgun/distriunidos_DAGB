package co.store.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 9155207683549402760L;

	/* Atributos */

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "name")
	private String name;

	@Column(name = "addres")
	private String addres;

	@Column(name = "phone")
	private String phone;

	@Column(name = "token")
	private String token;

	@Column(name = "enable")
	private String enable;

	/* Llaves foraneas y relaciones */

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<ShoppingCart> shopCart = new ArrayList<>();

	/* Constructor sobrecargado */

	public Customer(String email, String name, String addres, String phone, String token, String enable) {
		super();
		this.email = email;
		this.name = name;
		this.addres = addres;
		this.phone = phone;
		this.token = token;
		this.enable = enable;
	}

	/* Constructor */

	public Customer() {
		super();
	}

	/* Getters y Setters */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}// END CLASS
