package co.store.app.dto;

import java.io.Serializable;

public class PaymentMethodDTO implements Serializable {

	/* Atributos */

	private int payId;
	private String name;
	private String enable;

	/* Constructor sobrecargado */


	/* Constructor */

	public PaymentMethodDTO() {
		super();
	}

	/* Getters y Setters */

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}// END CLASS
