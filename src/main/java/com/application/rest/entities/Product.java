package com.application.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "producto")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String name;
    //cuando trabajemos con dinero usemos bigdecimal ya que tiene mucha cuando se trata de monedas
    @Column(name = "precio")
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "id_fabricante",nullable = false)
    @JsonIgnore

    private Maker  maker;
}

