package com.compasso.productmanagement.framework.adapter.out.rest;

import com.compasso.productmanagement.application.port.out.ProductManagementApiPortOut;
import com.compasso.productmanagement.domain.dto.ProductRequestDto;
import com.compasso.productmanagement.domain.dto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class ProductManagementApiPortOutImpl implements ProductManagementApiPortOut {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<ProductResponseDto> insert(ProductRequestDto body) {
        var httpHeader = new HttpHeaders();
        httpHeader.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<ProductResponseDto> productResponse =
                restTemplate.postForEntity("http://localhost:9999/products/", body, ProductResponseDto.class);
        return productResponse;
    }

    @Override
    public ResponseEntity<ProductResponseDto[]> findAll() {
        var httpHeader = new HttpHeaders();
        httpHeader.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<ProductResponseDto[]> productResponse;

        productResponse = restTemplate.getForEntity("http://localhost:9999/products/", ProductResponseDto[].class);

        return productResponse;

    }

    @Override
    public ResponseEntity<ProductResponseDto> findById(String id) {

        var httpHeader = new HttpHeaders();
        httpHeader.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<ProductResponseDto> productResponse =
                restTemplate.getForEntity("http://localhost:9999/products/" + id, ProductResponseDto.class);

        return productResponse;
    }

    @Override
    public ResponseEntity<ProductResponseDto[]> search(String query, Double minPrice, Double maxPrice) {
        var httpHeader = new HttpHeaders();
        httpHeader.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<ProductResponseDto[]> productResponse;

        productResponse = restTemplate.getForEntity("http://localhost:9999/products/" + query + minPrice + maxPrice, ProductResponseDto[].class);

        return productResponse;
    }


    @Override
    public ResponseEntity<ProductResponseDto> update(String id, ProductRequestDto body) {
        var httpHeader = new HttpHeaders();
        httpHeader.setContentType(MediaType.APPLICATION_JSON);

        restTemplate.put("http://localhost:9999/products/" + id, body);
        ResponseEntity<ProductResponseDto> productResponse =
                restTemplate.getForEntity("http://localhost:9999/products/" + id, ProductResponseDto.class);
        return productResponse;
    }

    @Override
    public void delete(String id) {
        var httpHeader = new HttpHeaders();
        httpHeader.setContentType(MediaType.APPLICATION_JSON);

        restTemplate.delete("http://localhost:9999/products/" + id);

    }
}
