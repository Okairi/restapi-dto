package com.application.rest.repository;

import com.application.rest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductsRepository extends CrudRepository<Product,Long> {

 //dos formas de hacer consultas personalizadas

 List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
// @Query("SELECT p from Product p where p.price between ?1 and ?2")
 @Query("SELECT p from Product p where p.price >= ?1 and p.price <= ?2")
 List<Product> findProductByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);



}
