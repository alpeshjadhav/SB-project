package com.v1.tut.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;
    private String prodName;
    private String prodDescription;
    private String prodBrand;
    private BigDecimal prodPrice;
    private String prodCategory;

    @CreatedDate
    @Column(updatable = false)
    private Date prodReleaseDate;
    private boolean prodAvailable;
    private int prodQuantity;
}
