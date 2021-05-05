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

@Entity
@Table(name = "product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8922252541387261720L;

	/* Atributos */


	@Id
	@Column(name = "pro_id")
	private int proId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private float price;

	@Column(name = "detail")
	private String detail;

	@Column(name = "image")
	private String image;

	@Column(name = "enable")
	private String enable;

	/* Llaves foraneas y relaciones */

//	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<ShoppingProduct> shopCart = new ArrayList<>();

	/* Constructor sobrecargado */
	public Product(int proId, String name, float price, String detail, String image, String enable) {
		super();
		this.proId = proId;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.image = image;
		this.enable = enable;
	}

	/* Constructor */
	public Product() {
		super();
	}

	/* Getters y Setters */
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}// END CLASS
