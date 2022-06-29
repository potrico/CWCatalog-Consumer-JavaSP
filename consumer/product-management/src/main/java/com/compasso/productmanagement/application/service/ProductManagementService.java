package com.compasso.productmanagement.application.service;

import com.compasso.productmanagement.application.port.in.ProductManagementUseCase;
import com.compasso.productmanagement.application.port.out.ProductManagementApiPortOut;
import com.compasso.productmanagement.domain.dto.ProductRequestDto;
import com.compasso.productmanagement.domain.dto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductManagementService implements ProductManagementUseCase {

    @Autowired
    private ProductManagementApiPortOut apiPortOut;


    @Override
    public ResponseEntity<ProductResponseDto> insert(ProductRequestDto body) {
        ResponseEntity<ProductResponseDto> productResponse = apiPortOut.insert(body);
        return productResponse;
    }

    @Override
    public ResponseEntity<ProductResponseDto> findById(String id) {
        ResponseEntity<ProductResponseDto> productResponse = apiPortOut.findById(id);
        return productResponse;
    }

    @Override
    public ResponseEntity<ProductResponseDto> update(String id, ProductRequestDto body) {
        ResponseEntity<ProductResponseDto> productResponse = apiPortOut.update(id, body);
        return productResponse;
    }

    @Override
    public ResponseEntity<ProductResponseDto[]> findAll() {
        ResponseEntity<ProductResponseDto[]> productResponse = apiPortOut.findAll();
        return productResponse;
    }

    @Override
    public void delete(String id) {
        apiPortOut.delete(id);
    }
}
