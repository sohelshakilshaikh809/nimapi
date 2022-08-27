package com.NimapInfotech.Nimap.ProductEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.NimapInfotech.Nimap.CategoryEntity.Category;
@Entity
//@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ProductId;
	private String ProductName;
	private long ProductPrice;
	
	@ManyToOne(cascade = CascadeType.MERGE)
//	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public long getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(long productPrice) {
		ProductPrice = productPrice;
	}
	
	public Product(int productId, String productName, long productPrice) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductPrice = productPrice;
	}
	
	public Product() {
		super();
	}
	
    	
}
