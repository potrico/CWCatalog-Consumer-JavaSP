package com.cristian.cwcatalog.dto;

import java.io.Serializable;

import com.cristian.cwcatalog.entities.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String description;
	private Double price;

	public ProductDTO() {
	}

	public ProductDTO(String id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
	}
}
