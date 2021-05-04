package co.store.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4631190849944764498L;

	/* Atributos */


	@Id
	@Column(name = "car_id")
	private int carId;

	@Column(name = "total")
	private float total;

	@Column(name = "items")
	private int items;

	@Column(name = "enable")
	private String enable;

	/* Llaves foraneas y relaciones */

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email", nullable = false)
	private Customer customer;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pay_id", nullable = false)
	private PaymentMethod paymentMethod;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart")
	private List<ShoppingProduct> shopCart = new ArrayList<>();


	/* Constructor sobrecargado */
	public ShoppingCart(int carId, float total, int items, String enable, Customer customer,
			PaymentMethod paymentMethod) {
		super();
		this.carId = carId;
		this.total = total;
		this.items = items;
		this.enable = enable;
		this.customer = customer;
		this.paymentMethod = paymentMethod;
	}

	/* Constructor */
	public ShoppingCart() {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}// END CLASS
