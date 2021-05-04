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
@Table(name = "payment_method")
public class PaymentMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1037911951387591941L;

	/* Atributos */


	@Id
	@Column(name = "pay_id")
	private int payId;

	@Column(name = "name")
	private String name;

	@Column(name = "enable")
	private String enable;

	/* Llaves foraneas y relaciones */

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMethod")
	private List<ShoppingCart> shopCart = new ArrayList<>();

	/* Constructor sobrecargado */

	public PaymentMethod(int payId, String name, String enable) {
		super();
		this.payId = payId;
		this.name = name;
		this.enable = enable;
	}

	/* Constructor */

	public PaymentMethod() {
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
