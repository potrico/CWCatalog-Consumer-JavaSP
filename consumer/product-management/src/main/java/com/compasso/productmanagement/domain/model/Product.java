package com.compasso.productmanagement.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    private String name;
    private String description;
    private Double price;
}
