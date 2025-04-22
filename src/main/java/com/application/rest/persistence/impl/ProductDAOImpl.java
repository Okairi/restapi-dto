package com.application.rest.persistence.impl;

import com.application.rest.entities.Product;
import com.application.rest.persistence.IProductDAO;
import com.application.rest.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Component

public class ProductDAOImpl  implements IProductDAO {


    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return this.productsRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) this.productsRepository.findAll();

    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return this.productsRepository.findProductByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
this.productsRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
this.productsRepository.deleteById(id);
    }
}
