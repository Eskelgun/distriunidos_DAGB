package co.store.app.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

	/* Atributos */

	private String email;
	private String name;
	private String addres;
	private String phone;
	private String token;
	private String enable;

	/* Constructor sobrecargado */


	/* Constructor */

	public CustomerDTO() {
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
