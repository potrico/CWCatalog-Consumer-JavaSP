package com.cristian.cwcatalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cristian.cwcatalog.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	
	@Query(" SELECT obj FROM Product obj"
			+ " WHERE (COALESCE(:minPrice) IS NULL OR obj.price >= :minPrice)"
			+ "	AND (COALESCE(:maxPrice) IS NULL OR obj.price <= :maxPrice)"
			+ "	AND ((COALESCE(:query) IS NULL OR LOWER(obj.description) LIKE LOWER(CONCAT('%', :query, '%'))"
			+ " OR  LOWER(obj.name) LIKE LOWER(CONCAT('%', :query, '%'))))")
	List<Product> findByNameAndDescriptionAndPrice(String query, Double minPrice, Double maxPrice);
}
