package com.vastracart.controller;


import com.vastracart.entity.Category;
import com.vastracart.entity.resposneDto.CategoryResposneDTO;
import com.vastracart.service.serviceInt.CategoryServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryServiceInt categoryServiceInt;


    @GetMapping("/getCategory/{name}")
    public ResponseEntity<CategoryResposneDTO> loadCategoryByName(@PathVariable String  name){
        CategoryResposneDTO categoryResposneDTO=new CategoryResposneDTO();

        Optional<Category> category = categoryServiceInt.findByCategoryName(name);

        List<Category> categoryList=category.stream().collect(Collectors.toList());
        if(category.isPresent()) {
            categoryResposneDTO.setResposneBody(categoryList);
            categoryResposneDTO.setResposneStatus("SUCCESS");
            categoryResposneDTO.setResponseMessage("Fetch Data Successfully !!");
            return new ResponseEntity<CategoryResposneDTO>(categoryResposneDTO, HttpStatus.OK);
        }else{
            categoryResposneDTO.setResposneStatus("FAILED");
            categoryResposneDTO.setResponseMessage("no data found");
            return new ResponseEntity<CategoryResposneDTO>(categoryResposneDTO,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryResposneDTO> saveProduct(@RequestBody Category category){
        CategoryResposneDTO CategoryResposneDTO=new CategoryResposneDTO();
        Category category1=categoryServiceInt.saveCategory(category);
        List<Category> categoryList=new ArrayList<>();
        categoryList.add(category1);
        if(category1==null){
            CategoryResposneDTO.setResposneStatus("FAILED");
            CategoryResposneDTO.setResponseMessage("COULD NOT SAVE DATA !!");
            return new ResponseEntity<CategoryResposneDTO>(CategoryResposneDTO,HttpStatus.SERVICE_UNAVAILABLE);
        }else{
            CategoryResposneDTO.setResposneBody(categoryList);
            CategoryResposneDTO.setResposneStatus("SUCCESS");
            CategoryResposneDTO.setResponseMessage("SAVE DATA SUCCESSFULLY !!");
            return new ResponseEntity<CategoryResposneDTO>(CategoryResposneDTO,HttpStatus.OK);
        }
    }

    @PostMapping("updateCanceledById")
    public ResponseEntity<CategoryResposneDTO> updateCancel(@RequestBody Category category){
        CategoryResposneDTO categoryResposneDTO=new CategoryResposneDTO();

        try {
            categoryServiceInt.updateById(category.getCanceled(), category.getCategoryId());
            List<Category> categoryList = new ArrayList<>();
            categoryList.add(category);
            categoryResposneDTO.setResposneBody(categoryList);
            categoryResposneDTO.setResposneStatus("SUCCESS");
            categoryResposneDTO.setResponseMessage("UPDATED SUCCESSFULLY !!");
            return new ResponseEntity<CategoryResposneDTO>(categoryResposneDTO, HttpStatus.OK);
        }catch (Exception e){
            categoryResposneDTO.setResposneStatus("FAILURE");
            categoryResposneDTO.setResponseMessage("NOT UPDATED SUCCESSFULLY !!");
            return new ResponseEntity<CategoryResposneDTO>(categoryResposneDTO, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getCategory/canceled/{canceled}")
    public ResponseEntity<CategoryResposneDTO> loadAllCanceled(@PathVariable int  canceled){
        CategoryResposneDTO categoryResposneDTO=new CategoryResposneDTO();
        List<Category> category = categoryServiceInt.getListByCanceled(canceled);
        categoryResposneDTO.setResposneBody(category);
        categoryResposneDTO.setResposneStatus("SUCCESS");
        categoryResposneDTO.setResponseMessage("DATA FETCHED SUCCESSFULLY !!");
        return new ResponseEntity<CategoryResposneDTO>( categoryResposneDTO, HttpStatus.OK);

    }
}
