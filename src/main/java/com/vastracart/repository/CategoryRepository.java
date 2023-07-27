package com.vastracart.repository;

import com.vastracart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


    Optional<Category> findByCategoryName(String categoryName);

    @Modifying
    @Query("update Category u set u.canceled = ?1 where u.categoryId = ?2")
    void updateCategoryById(int canceled,Long categoryId);


    @Query(value = "SELECT * FROM Category where canceled = ?1", nativeQuery = true)
    List<Category> getCategoryByCanceled(int canceled);
}
