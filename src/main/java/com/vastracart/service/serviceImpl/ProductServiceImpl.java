package com.vastracart.service.serviceImpl;

import com.vastracart.entity.Product;
import com.vastracart.repository.ProductRepository;
import com.vastracart.service.serviceInt.ProductServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductServiceInt {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> getByName(String name) {

        Optional<Product> product = productRepository.findByName(name);
        return product;
    }

    @Override
    public Optional<Product> getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @Override
    public List<Product> getList() {
        List<Product> product = productRepository.findAll();
        return product;
    }

    @Override
    public Product saveProduct(Product product) {
        Product product1 = productRepository.save(product);
        return product1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateProduct(String name,Long id) {
        productRepository.updateProductById(name,id);
    }
}
