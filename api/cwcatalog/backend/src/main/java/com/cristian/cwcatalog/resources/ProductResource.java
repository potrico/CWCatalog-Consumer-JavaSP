package com.cristian.cwcatalog.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cristian.cwcatalog.dto.ProductDTO;
import com.cristian.cwcatalog.dto.ProductInsertDTO;
import com.cristian.cwcatalog.exceptions.ResourceNotFoundException;
import com.cristian.cwcatalog.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;

	@PostMapping
	public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductInsertDTO dto) {

		ProductDTO newProduct = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProduct.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newProduct);

	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable String id) {
		try {
			ProductDTO product = service.findById(id);
			return ResponseEntity.ok().body(product);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(value = "/search")
	public ResponseEntity<List<ProductDTO>> search(
			@RequestParam(value = "min_price", defaultValue = "") Double minPrice,
			@RequestParam(value = "max_price", defaultValue = "") Double maxPrice,
			@RequestParam(value = "q", defaultValue = "") String q) {
		List<ProductDTO> product = service.search(q, minPrice, maxPrice);
		return ResponseEntity.ok().body(product);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> delete(@PathVariable String id) {
		try {
			service.delete(id);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable String id, @Valid @RequestBody ProductInsertDTO dto) {
		try {
			ProductDTO updatedDto = service.update(id, dto);
			return ResponseEntity.ok().body(updatedDto);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
