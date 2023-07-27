package com.vastracart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "SUB_CATEGORY")
@Getter
@Setter
@ToString
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SUB_CATEGORY_ID",nullable = false,unique = true)
    private Long subCategoryId;

    @Column(name="SUB_CATEGORY_NAME",length = 150,nullable = false,unique = true)
    private String subCategoryName;

    @Column(name="is_deleted",length = 1)
    private int deleted;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="CATEGORY_ID",nullable = false)
    @JsonBackReference
    private Category category;

}
