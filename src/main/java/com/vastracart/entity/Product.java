package com.vastracart.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_COMPANY")
    private String company;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "COLOR")
    private String colour;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "DESCRIPTION")
    private String description;


//private Category category;

    @Column(name = "FEATURED")
    private String featured;
}
