package co.store.app.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	/* Atributos */

	private int proId;
	private String name;
	private float price;
	private String detail;
	private String image;
	private String enable;

	/* Constructor sobrecargado */


	/* Constructor */
	public ProductDTO() {
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
