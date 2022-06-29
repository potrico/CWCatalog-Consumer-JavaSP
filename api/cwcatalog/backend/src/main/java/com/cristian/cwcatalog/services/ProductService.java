package com.cristian.cwcatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristian.cwcatalog.dto.ProductDTO;
import com.cristian.cwcatalog.dto.ProductInsertDTO;
import com.cristian.cwcatalog.entities.Product;
import com.cristian.cwcatalog.exceptions.ResourceNotFoundException;
import com.cristian.cwcatalog.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAll();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById(String id){
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ProductDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<ProductDTO> search(String query, Double minPrice, Double maxPrice){
		return repository.findByNameAndDescriptionAndPrice(query, minPrice, maxPrice).stream().map(
				x -> new ProductDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ProductDTO insert(ProductInsertDTO dto){
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO update(String id, ProductInsertDTO dto) {
		try {
			Product entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProductDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}
	
	@Transactional
	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	public void copyDtoToEntity(ProductInsertDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
	}
}
