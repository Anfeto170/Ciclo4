package co.edu.uelbosque.GenericStore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")

public class Product {

	@Id
	private String id;

	private int code, nitSupplier;
	private String name;
	private float purchasePrice, salePrice;

	public Product() {

	}

	public Product(int code, int nitSupplier, String name, float purchasePrice) {
		this.code = code;
		this.nitSupplier = nitSupplier;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salePrice = (float) ((purchasePrice * 0.19) + purchasePrice);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", code=" + code + ", nitSupplier=" + nitSupplier + ", name=" + name
				+ ", purchasePrice=" + purchasePrice + ", salePrice=" + salePrice + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getNitSupplier() {
		return nitSupplier;
	}

	public void setNitSupplier(int nitSupplier) {
		this.nitSupplier = nitSupplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}

}
