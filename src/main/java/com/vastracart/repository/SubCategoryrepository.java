package com.vastracart.repository;

import com.vastracart.entity.Category;
import com.vastracart.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategoryrepository extends JpaRepository<SubCategory,Long> {

    Optional<SubCategory> findBySubCategoryName(String subCategoryName);

//    @Modifying
//    @Query("update sub_Category s set s.deleted = ?1 where s.subCategoryId = ?2")
//    void updateCategoryById(int canceled,Long categoryId);


    @Query(value = "SELECT * FROM Category where canceled = ?1", nativeQuery = true)
    List<SubCategory> getCategoryByCanceled(int canceled);
}
