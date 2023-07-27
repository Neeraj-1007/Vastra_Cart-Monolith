package com.vastracart.controller;


import com.vastracart.entity.Category;
import com.vastracart.entity.Product;
import com.vastracart.entity.resposneDto.ProductResposneDTO;
import com.vastracart.service.serviceInt.ProductServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    @Autowired
    private ProductServiceInt productServiceInt;

    @GetMapping("/getProduct/name/{name}")
    private ResponseEntity<ProductResposneDTO> loadProductByName(@PathVariable String name) {
        ProductResposneDTO productResposneDTO = new ProductResposneDTO();
        Optional<Product> product = productServiceInt.getByName(name);
        if (!product.isPresent()) {
            productResposneDTO.setResposneStatus("FAILED");
            productResposneDTO.setResponseMessage("NO DATA FOUND !!");
            return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.NOT_FOUND);
        }
        List<Product> productList=product.stream().collect(Collectors.toList());
       productResposneDTO.setResponeBody(productList);
        productResposneDTO.setResposneStatus("SUCCESS");
        productResposneDTO.setResponseMessage("GET THE RESULT ");

        return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.FOUND);
    }

    @GetMapping("/getProduct/id/{id}")
    private ResponseEntity<ProductResposneDTO> loadProductById(@PathVariable Long id) {
        ProductResposneDTO productResposneDTO = new ProductResposneDTO();
        Optional<Product> product = productServiceInt.getById(id);
        if (!product.isPresent()) {
            productResposneDTO.setResposneStatus("FAILED");
            productResposneDTO.setResponseMessage("NO DATA FOUND !!");
            return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.NOT_FOUND);
        }
        List<Product> productList=product.stream().collect(Collectors.toList());
        productResposneDTO.setResponeBody(productList);
        productResposneDTO.setResposneStatus("SUCCESS");
        productResposneDTO.setResponseMessage("GET THE RESULT ");
        return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.FOUND);
    }

    @GetMapping("/getProduct")
    private ResponseEntity<ProductResposneDTO> loadProductAll() {
        ProductResposneDTO productResposneDTO=new ProductResposneDTO();
        List<Product> list = productServiceInt.getList();
        if (list.size() == 0) {
            productResposneDTO.setResposneStatus("SUCCESS");
            productResposneDTO.setResponseMessage("NO RECORD FOUND");
            return new ResponseEntity<ProductResposneDTO>((ProductResposneDTO) null, HttpStatus.NOT_FOUND);
        }
        productResposneDTO.setResponeBody(list);
        productResposneDTO.setResposneStatus("SUCCESS");
        productResposneDTO.setResponseMessage("Successfully Fetched Data");
        return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductResposneDTO> saveProduct(@RequestBody Product product) {
        ProductResposneDTO productResposneDTO=new ProductResposneDTO();
        List<Product> productList=new ArrayList<>();
        Product product1 = productServiceInt.saveProduct(product);
        productList.add(product1);
        if (product1 == null) {
            productResposneDTO.setResponeBody(null);
            productResposneDTO.setResposneStatus("FAILED");
            productResposneDTO.setResponseMessage("COULD NOT SAVE DATA !!");
            return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.SERVICE_UNAVAILABLE);
        } else {
            productResposneDTO.setResponeBody(productList);
            productResposneDTO.setResposneStatus("SUCCESS");
            productResposneDTO.setResponseMessage("SAVE DATA SUCCESSFULLY !!");
            return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ProductResposneDTO> updateProduct(@RequestBody Product product) {
        ProductResposneDTO productResposneDTO=new ProductResposneDTO();
        List<Product> productList=new ArrayList<>();
        try {
            productServiceInt.updateProduct(product.getName(), product.getId());
            productList.add(product);
            productResposneDTO.setResponeBody(productList);
            productResposneDTO.setResposneStatus("SUCCESS");
            productResposneDTO.setResponseMessage("SAVE DATA SUCCESSFULLY !!");
            return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
            productResposneDTO.setResposneStatus("FAILED");
            productResposneDTO.setResponseMessage(e.getMessage());
            return new ResponseEntity<ProductResposneDTO>(productResposneDTO, HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

}
