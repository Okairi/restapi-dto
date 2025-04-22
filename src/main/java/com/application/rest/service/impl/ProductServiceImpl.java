package com.application.rest.service.impl;

import com.application.rest.entities.Product;
import com.application.rest.persistence.IProductDAO;
import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO iProductDAO;

    @Override
    public Optional<Product> findById(Long id) {
        return this.iProductDAO.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.iProductDAO.findAll();
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return this.iProductDAO.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        this.iProductDAO.save(product);

    }

    @Override
    public void deleteById(Long id) {
this.iProductDAO.deleteById(id);
    }
}
