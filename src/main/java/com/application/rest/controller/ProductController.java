package com.application.rest.controller;


import com.application.rest.controller.dto.PriceRangeDTO;
import com.application.rest.controller.dto.ProductDTO;
import com.application.rest.entities.Product;
import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

@Autowired
    private IProductService iProductService;

@GetMapping("/findId/{id}")
public ResponseEntity<?> findById(@PathVariable Long id){

    Optional<Product> productOptional = this.iProductService.findById(id);


    if (productOptional.isPresent()){
        Product product = productOptional.get();

        ProductDTO productDTO = ProductDTO.builder().id(product.getId()).name(product.getName()).
                price(product.getPrice()).maker(product.getMaker()).build();





        return  ResponseEntity.ok(productDTO);
    }
    return ResponseEntity.notFound().build();

}

@GetMapping("/finAll")
public ResponseEntity<?>  findAll () {

    List<ProductDTO> productDTOS =  this.iProductService.findAll().stream().map(product ->

            ProductDTO.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).maker(product.getMaker()).build()
            ).toList();


return ResponseEntity.ok(productDTOS);

}

@GetMapping("findByPriceInRange")
public ResponseEntity<?> findByPriceInRange(@RequestBody PriceRangeDTO priceRange){
    List<ProductDTO> productsDTO = this.iProductService.findByPriceInRange(priceRange.getMinPrice(),priceRange.getMaxPrice()).stream().map(product ->

            ProductDTO.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).maker(product.getMaker()).build()
            ).toList();



return ResponseEntity.ok(productsDTO);

}

}
