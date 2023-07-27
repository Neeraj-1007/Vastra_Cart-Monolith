package com.vastracart.repository;

import com.vastracart.entity.Product;
import com.vastracart.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    @Override
    void deleteById(Long id);


    @Override
    void delete(Product entity);

    @Modifying
    @Query("update Product u set u.name = ?1 where u.id = ?2")
    void updateProductById(String name,Long id);
}
