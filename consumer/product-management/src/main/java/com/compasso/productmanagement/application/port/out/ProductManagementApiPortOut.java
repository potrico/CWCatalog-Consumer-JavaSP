package com.compasso.productmanagement.application.port.out;

import com.compasso.productmanagement.domain.dto.ProductRequestDto;
import com.compasso.productmanagement.domain.dto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductManagementApiPortOut {
    ResponseEntity<ProductResponseDto> insert(ProductRequestDto body);

    ResponseEntity<ProductResponseDto[]> findAll();

    ResponseEntity<ProductResponseDto> findById(String id);

    ResponseEntity<ProductResponseDto[]> search(String query, Double minPrice, Double maxPrice);

    ResponseEntity<ProductResponseDto> update(String id, ProductRequestDto body);

    public void delete(String id);

}
