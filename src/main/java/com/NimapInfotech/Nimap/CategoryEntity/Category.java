package com.NimapInfotech.Nimap.CategoryEntity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.NimapInfotech.Nimap.ProductEntity.Product;

@Entity
//@Table( name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CategoryId;
	private String CategoryName;
	private String CategoryDescription;
	
//    @OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="category_id", referencedColumnName = "categoryId")
//    private List<Product> products;
    
    
    @OneToMany(cascade = CascadeType.ALL)
//    ,mappedBy = "category",fetch = FetchType.LAZY)//2//
    @JoinColumn(name="category_id",referencedColumnName = "categoryId")
	private List<Product> products;

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(int categoryId, String categoryName, String categoryDescription, List<Product> products) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
		CategoryDescription = categoryDescription;
		this.products = products;
	}

	public Category() {
		super();
	}
	
    
	}