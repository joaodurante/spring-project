package com.joaodurante.springfirst.services;

import com.joaodurante.springfirst.domain.Product;
import com.joaodurante.springfirst.repositories.ProductRepository;
import com.joaodurante.springfirst.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public Product find(Integer id){
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object was not found using the id: " + id));
    }
}