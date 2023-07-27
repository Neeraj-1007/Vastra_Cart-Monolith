package com.vastracart.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CATEGORY_ID",nullable = false,unique = true)
    private Long categoryId;

    @Column(name="CATEGORY_NAME",length = 150,nullable = false,unique = true)
    private String categoryName;

    @Column(name="CREATED_BY",nullable = false,length = 150)
    private String createdBy;

    @Column(name="UPDATED_BY",nullable = false,length = 150)
    private String updatedBy;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<SubCategory> subCategorySet;

    @Column(name="CANCELED",length = 1,nullable = true)
    private int canceled;

}
