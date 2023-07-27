package com.vastracart.service.serviceImpl;

import com.vastracart.entity.SubCategory;
import com.vastracart.repository.SubCategoryrepository;
import com.vastracart.service.serviceInt.SubCategoryServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryServiceImpl implements SubCategoryServiceInt {
    @Autowired
    private SubCategoryrepository  subCategoryRepository;


    @Override
    public Long loadSubCategory(SubCategory subCategory) {
        SubCategory subCategory1=  subCategoryRepository.save(subCategory);
        return subCategory1.getSubCategoryId();
    }
}
