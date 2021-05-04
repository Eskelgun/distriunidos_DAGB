package co.store.app.dto;

import java.io.Serializable;

public class ShoppingCartDTO implements Serializable {

	/* Atributos */

	private int carId;
	private float total;
	private int items;
	private String enable;

	/* Llaves foraneas y relaciones */
	private String email;
	private int payId;

	/* Constructor sobrecargado */


	/* Constructor */
	public ShoppingCartDTO() {
		super();
	}

	/* Getters y Setters */
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}


}// END CLASS
