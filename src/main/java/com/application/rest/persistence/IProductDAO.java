package com.application.rest.persistence;

import com.application.rest.entities.Maker;
import com.application.rest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {


    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    void save(Product product  );
    void deleteById(Long id);

}
