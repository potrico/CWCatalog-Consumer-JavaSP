package com.compasso.productmanagement.application.port.in;

import com.compasso.productmanagement.domain.dto.ProductRequestDto;
import com.compasso.productmanagement.domain.dto.ProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductManagementUseCase {

    ResponseEntity<ProductResponseDto> insert(ProductRequestDto body);

    public ResponseEntity<ProductResponseDto[]> findAll();

    ResponseEntity<ProductResponseDto> findById(String id);

    //List<ProductResponseDto> search(String query, Double minPrice, Double maxPrice);

    ResponseEntity<ProductResponseDto> update(String id, ProductRequestDto body);

    public void delete(String id);


}
