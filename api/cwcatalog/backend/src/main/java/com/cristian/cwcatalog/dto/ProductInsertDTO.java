package com.cristian.cwcatalog.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInsertDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Valor 'name' é  obrigatório")
	private String name;
	@NotNull(message = "Valor 'description' é  obrigatório")
	private String description;
	@NotNull(message = "Valor 'price' é  obrigatório")
	@Positive(message = "Valor 'price' deve ser positivo")
	private Double price;

	public ProductInsertDTO() {
	}
}
