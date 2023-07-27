package com.vastracart.service.serviceImpl;

import com.vastracart.entity.Category;
import com.vastracart.repository.CategoryRepository;
import com.vastracart.repository.SubCategoryrepository;
import com.vastracart.service.serviceInt.CategoryServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryServiceInt {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryrepository subCategoryRepository;


    @Override
    public Long loadCategory(Category category) {
        Category category1 = categoryRepository.save(category);
        return category1.getCategoryId();
    }

    @Override
    public Optional<Category> findByCategoryName(String categoryName) {
        Optional<Category> category = categoryRepository.findByCategoryName(categoryName);
        return category;
    }

    @Override
    public Category saveCategory(Category category) {
        Category category1 = categoryRepository.save(category);
        return category1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateById(int canceled,Long categoryId) {
        categoryRepository.updateCategoryById(canceled,categoryId);
    }

    @Override
    public List<Category> getListByCanceled(int canceled) {
        List<Category> categoryList=categoryRepository.getCategoryByCanceled(canceled);
        return categoryList;
    }

}
