package com.compasso.productmanagement.domain.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDto {

    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private Double price;

}
