package com.compasso.productmanagement.framework.adapter.in.rest;

import com.compasso.productmanagement.domain.dto.ProductRequestDto;
import com.compasso.productmanagement.domain.dto.ProductResponseDto;
import com.compasso.productmanagement.framework.adapter.out.rest.ProductManagementApiPortOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/productInventory/producatManagement/v1/products")
public class ProductManagementController {

    @Autowired
    private ProductManagementApiPortOutImpl service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable String id){
        return service.findById(id);
    }

    @GetMapping
    public ResponseEntity<ProductResponseDto[]> findAll(){
        return service.findAll();
    }

    @PostMapping
        public ResponseEntity<ProductResponseDto> insert(@RequestBody ProductRequestDto body){
        return service.insert(body);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable String id, @RequestBody ProductRequestDto body){
        service.update(id, body);
    }
}
