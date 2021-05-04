package co.store.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shopping_product")
public class ShoppingProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1579088988245768194L;

	/* Atributos */


	@Id
	@Column(name = "shop_id")
	private int shopId;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total")
	private float total;
	
	/* Llaves foraneas y relaciones */

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id", nullable = false)
	private Product product;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", nullable = false)
	private ShoppingCart shoppingCart;
	
	/* Constructor sobrecargado */
	public ShoppingProduct(int shopId, int quantity, float total, Product product, ShoppingCart shoppingCart) {
		super();
		this.shopId = shopId;
		this.quantity = quantity;
		this.total = total;
		this.product = product;
		this.shoppingCart = shoppingCart;
	}

	/* Constructor */
	public ShoppingProduct() {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}// END CLASS
