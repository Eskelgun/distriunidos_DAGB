package co.store.app.dto;

import java.io.Serializable;

public class ShoppingProductDTO implements Serializable {

	/* Atributos */

	private int shopId;
	private int quantity;
	private float total;
	
	/* Llaves foraneas y relaciones */
	private int proId;
	private int carId;
	
	/* Constructor sobrecargado */


	/* Constructor */
	public ShoppingProductDTO() {
		super();
	}

	/* Getters y Setters */
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}


}// END CLASS
